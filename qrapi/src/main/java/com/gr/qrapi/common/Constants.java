package com.gr.qrapi.common;

import java.util.HashMap;
import com.gr.common.model.Error;

import com.gr.common.util.properties.ApplicationProperties;

/**
 * This file will contain constants that will be used in web services
 * @author ufarooq
 */
public interface Constants {
	
	String HEADER_X_SOURCE = "X_SOURCE";
	String HEADER_X_REQUEST_CODE = "X_REQUEST_CODE";
	String HEADER_X_USERNAME = "X_USERNAME";
	String HEADER_X_AUTHORIZATION = "X_AUTHORIZATION";
	
	String HEADER_X_PASSWORD = "X_PASSWORD";
	String HEADER_X_PARTNER_GUID = "X_PARTNER_GUID";
	String HEADER_X_REQUEST_ID = "X_REQUEST_ID";
	
	String PROP_GWS_AUTH_TOKEN = ApplicationProperties.getProperty("gwsAuthToken");
	String PROP_GWS_SOURCE = ApplicationProperties.getProperty("gwsSource");
	String PROP_GWS_URL = ApplicationProperties.getProperty("gwsUrl");
	
	String PROP_SERVER_NAME = ApplicationProperties.getProperty("serverName");

	String SOURCE_KEY = "source";
	
	// API RESPONSE MESSAGES AND STATUS CODES
	String STATUS_SUCCESS = "Success";
	String STATUS_FAILURE = "Failure";

	String SUBJECT_VALIDATION_FAILURE = "Validation Fail";

	String STATUS_CODE_100 = "100";
	String STATUS_CODE_101 = "101";
	String STATUS_CODE_102 = "102";
	String STATUS_CODE_103 = "103";
	String STATUS_CODE_104 = "104";
	String STATUS_CODE_105 = "105";
	String STATUS_CODE_106 = "106";
	String STATUS_CODE_107 = "107";
	
	String GWS_STATUS_CODE_100 = "100";
	String GWS_STATUS_CODE_200 = "200";
	String GWS_STATUS_CODE_201 = "201";
	String GWS_STATUS_CODE_202 = "202";

	String STATUS_CODE_MESSAGE_100 = "Request processed successfully";
	String STATUS_CODE_MESSAGE_101 = "Authentication Failure";
	String STATUS_CODE_MESSAGE_102 = "Access Denied";
	String STATUS_CODE_MESSAGE_103 = "Data Malformed";
	String STATUS_CODE_MESSAGE_104 = "Invalid Parameter";
	String STATUS_CODE_MESSAGE_105 = "Business Rule Failure";
	String STATUS_CODE_MESSAGE_106 = "Something went wrong";
	String STATUS_CODE_MESSAGE_107 = "Method not found";

	HashMap<String, String> ERROR_MAPPINGS = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put(Error.Codes.BR_CAS_001, Error.Codes.BR_CAS_001);
		}
	};
	
	String USERACTIVITY_TYPE_QRAPI = "QRAPI";
	String USERACTIVITY_TYPE_GWS = "GWS";
	
	String PACKAGE_GR_SIGNATURE_TITLE = "Global Rescue Signature";
	String PACKAGE_GR_SIGNATURE_PLUS_TITLE = "Global Rescue Signature Plus";

	// Helpers
	String EMPTY_GUID = "00000000-0000-0000-0000-000000000000";
	String USSA_GUID = "0fde1d01-1806-e211-9be9-000c2972e8b4";
	
	// GWS API URI
	String GWS_API_URL_TI_QUOTE = "travelinsurance/quote/";
	String GWS_API_URL_TI_PREPAID_BUY = "travelinsurance/prepaid/buy/";
	String GWS_API_URL_TI_POSTPAID_BUY = "travelinsurance/postpaid/buy/";
	String GWS_API_URL_MEM_NEW_PREPAID = "membership/new/prepaid/";
	String GWS_API_URL_MEM_NEW_POSTPAID = "membership/new/postpaid/";
	String GWS_API_URL_MEM_RENEW_PREPAID = "membership/renew/prepaid/";
	String GWS_API_URL_MEM_POSTPAID = "membership/postpaid/";
	String GWS_API_URL_MEM_VALIDATE = "membership/validate/";
	String GWS_API_URL_ADMIN_PARTNER_PACKAGES = "partner/partnerpackages/";
	String GWS_API_URL_ADMIN_PACKAGES_BY_GUIDS = "partner/packagesbyguids/";
	String GWS_API_URL_ADMIN_PARTNER_SPECIAL_PACKAGES = "partner/specialpackages/";
	String GWS_API_URL_IS_UNIQUE_EMAIL_ADDRESS = "isvaliduniqueemailaddress/";
	String GWS_API_URL_PACKAGE_BY_CODE = "partner/packagebycode/";
	
	String GWS_API_URL_MEM_QUOTE = "membership/quote/";
	String GWS_API_URL_MEM_COUNT = "membership/%s/count/";
	String GWS_API_URL_MEM_ALL = "membership/%s/all/";
	String GWS_API_URL_MEM_LAST_CONTRACT = "membership/%s/lastcontract/";
	String GWS_API_URL_MEM_LATEST_CONTRACT = "membership/%s/latestcontract/";
	String GWS_API_URL_CONTACT_GUID = "contacts/%s/guid";
	String GWS_API_URL_CONTACT_ADD_FAMILY_MEMBER = "contract/%s/familymember/";
	String GWS_API_URL_CONTACT_FAMILY_MEMBERS = "contacts/%s/familymembers";
	String GWS_API_URL_SHIPMENT_COST = "shipmentcost/";

	String GWS_API_URL_CONTACT_BY_EMAIL_OR_MEMBERID = "contacts/bymemberidoremail";
	String GWS_API_URL_CONTACT_HAS_MEDICAL_DEVICE = "contacts/hasmedicaldevice";
	
	String PRODUCT_TYPE_TRAVEL = "Travel";
	String PRODUCT_TYPE_TOTAL_CARE = "TotalCare";
	
	String SIGNUP_AS_MEMBER = "member";
	
	String MEMBERSHIP_TYPE_NEW = "New";
	String MEMBERSHIP_TYPE_RENEW = "Renew";
	
	String PAYMENT_MODE_NONE = "None";
	String PAYMENT_MODE_CREDIT_CARD = "Credit Card";

	// SWAGGER
	String SWAGGER_SPECS_APIDOCS = "swagger/v2/docs.json";
	String SWAGGER_SPECS_GENERAL = "swagger/general.json";
	String SWAGGER_SPECS_TI = "swagger/ti.json";
	String SWAGGER_SPECS_MEMBERSHIP = "swagger/membership.json";
	String SWAGGER_HOST_KEY = "host";
}
