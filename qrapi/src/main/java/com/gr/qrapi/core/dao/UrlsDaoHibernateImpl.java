package com.gr.qrapi.core.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import com.gr.common.dao.AbstractHibernateDao;
import com.gr.common.dao.DaoException;
import com.gr.common.dao.DaoManager;
import com.gr.qrapi.core.model.Url;
import com.gr.qrapi.core.model.Url_Stats;
import com.gr.qrapi.ws.skeleton.Click_Stat_Model;
import com.gr.qrapi.ws.skeleton.ListModel;
import com.gr.qrapi.ws.skeleton.Url_Details;

public class UrlsDaoHibernateImpl extends AbstractHibernateDao<Url, Integer> implements UrlsDao {

	public static UrlsDao getDao() {
		return DaoManager.getInstance().getDao(UrlsDao.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Url> getAllURLs() {

		try {
			Session session = getSession();
			Criteria criteria = session.createCriteria(Url.class);
			criteria.setMaxResults(100);
			List<Url> URLs = (List<Url>) criteria.list();
			return URLs;
		} catch (Exception aex) {
			throw new DaoException(aex);
		}
	}

	@Override
	public Url addURL(Url url) {
		Session session = null;
		Integer ID = null;
		List<Url> urls = getAllURLs();
		Url addedURL=null;
		for (Url myUrl : urls) {
			if (myUrl.getLongURL().equals(url.getLongURL())) {
				return null;
			}
		}
		try {
			session = getSession();
			session.beginTransaction();
			ID = (Integer) session.save(url);
			String enc_ID = generateShortenURL(ID);
			updateShortenURL(enc_ID, session);
			addedURL=(Url) session.get(Url.class,ID);
			addedURL.setShortURL("gr-us/gr" + enc_ID);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			if (session != null)
				if (session.isOpen()) {
					session.close();
				}
		}
		return addedURL;
	}

	@Override
	public Url searchURLByID(int urlID) {
		Session session = null;
		Url retrievedURL = null;
		try {
			session = getSession();
			session.beginTransaction();
			retrievedURL = (Url) session.get(Url.class, urlID);
			if (retrievedURL == null) {
				if (session.isOpen()) {
					session.close();
				}
				System.out.println("URL Search Op: URL not Found!");
				return null;
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("URL Search Op: Hibernate is unable to communicate with database");
			return null;
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return retrievedURL;
	}

	@Override
	public boolean addUrlDetail(Url_Stats url_stats, int urlID) {
		Url myurl = null;
		Session session = null;
		try {
			session = getSession();
			session.beginTransaction();
			myurl = (Url) session.get(Url.class, urlID);
			if (myurl == null) {
				if (session != null)
					if (session.isOpen()) {
						session.close();
					}
				return false;
			}
			myurl.getUrlStatList().add(url_stats);
			session.saveOrUpdate(myurl);
			session.save(url_stats);
			session.getTransaction().commit();
		} catch (Exception hbe) {
			session.getTransaction().rollback();
			hbe.printStackTrace();
			return false;
		} finally {
			if (session != null)
				if (session.isOpen()) {
					session.close();
				}
		}
		return true;
	}

	@SuppressWarnings({ "unchecked"})
	@Override
	public List<Click_Stat_Model> getClickStats(int urlID) {
		List<Click_Stat_Model> clickStatList = new ArrayList<>();
		Session session = null;
		try {
			session = getSession();
			session.beginTransaction();
			Query query = session.createQuery("select cast(year(clickDate) as string) as label, cast(Count(*) as int) as data from Url_Stats where url_ID = " + urlID + " group by year(clickDate)").setResultTransformer(
					Transformers.aliasToBean(ListModel.class));
			List<ListModel> yearlyStats = (List<ListModel>) query.list();
			if (yearlyStats == null) {
					if (session.isOpen()) {
						session.close();
					}
				return null;
			}
			
			clickStatList.add(populateStats(yearlyStats));
			
			query = session.createQuery("select cast(browser as string) as label, cast(Count(*) as int) as data from Url_Stats where url_ID = " + urlID + " group by browser").setResultTransformer(
					Transformers.aliasToBean(ListModel.class));
			List<ListModel> browserStats = (List<ListModel>) query.list();
			if (browserStats == null) {
					if (session.isOpen()) {
						session.close();
					}
				return null;
			}
			
			clickStatList.add(populateStats(browserStats));
			
			query = session.createQuery("select cast(platform as string) as label, cast(Count(*) as int) as data from Url_Stats where url_ID = " + urlID + " group by platform").setResultTransformer(
					Transformers.aliasToBean(ListModel.class));
			List<ListModel> platformStats = (List<ListModel>) query.list();
			if (platformStats == null) {
					if (session.isOpen()) {
						session.close();
					}
				return null;
			}
			
			clickStatList.add(populateStats(platformStats));
			
			session.getTransaction().commit();
		} catch (Exception hbe) {
			session.getTransaction().rollback();
			hbe.printStackTrace();
			return null;
		} finally {
			if (session != null)
				if (session.isOpen()) {
					session.close();
				}
		}
		return clickStatList;
	}
	
	@Override
	public Url_Details getURLDetails(int urlID) {
		Session session = null;
		Url_Details url_Details = null;
		try {
			session = getSession();
			session.beginTransaction();
			Url retrievedURL = (Url) session.get(Url.class, urlID);
			if (retrievedURL == null) {
				if (session.isOpen()) {
					session.close();
				}
				return null;
			}
			url_Details=new Url_Details(retrievedURL.getShortURL(),retrievedURL.getStartingDate().toString().split(" ")[0], retrievedURL.getLongURL(), retrievedURL.getUrlStatList().size());
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return url_Details;
	}
	
	private String generateShortenURL(Integer ID) {
		return Integer.toHexString(ID);
	}

	private void updateShortenURL(String ID, Session session) {
		String shortURL = "gr-us/gr" + ID;
		Query query = session
				.createQuery("update Url set short_url = :shortUrl where Id = " + Integer.parseInt(ID, 16));
		query.setParameter("shortUrl", shortURL);
		query.executeUpdate();
	}
	
	private Click_Stat_Model populateStats(List<ListModel> Stats) {
		Click_Stat_Model click_Stats = new Click_Stat_Model();
		for(ListModel model:Stats) {
			click_Stats.getLabelList().add(model.getLabel());
			click_Stats.getDataList().add((Integer)model.getData());
		}
		return click_Stats;
		
	}
	

}
