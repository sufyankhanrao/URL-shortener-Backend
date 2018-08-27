var businessRules = [
	{
		"code" : "BR-CAS-001",
		"message" : "This credit card type is not supported by Global Rescue",
		"br" : "The system should accept following credit cards for transactions. <br/> Visa <br/> Master <br/> American Express <br/> Discover"
	},
	{
		"code" : "BR-CAS-006",
		"message" : "Must contain English alphabets. Periods and hyphens are allowed. Must be between 2 - 45 characters.First character should be an English alphabet.",
		"br" : "The system should check if any of the conditions listed are met. <br/> First character should be an alphabet <br/> Contains A-Z, a-z <br/> ASCII <br/> Special characters period(,), hyphen (-) <br/> Minimum Character: 2 <br/> Maximum Characters: 45 <br/> Digits 0-9 <br/> Space is allowed"
	},
	{
		"code" : "BR-CAS-008",
		"message" : "{Field} is already a part of this membership",
		"br" : "The first name, last name and date of birth of two family members cannot be same for a family membership."
	},
	{
		"code" : "BR-CAS-009",
		"message" : "{Field} already exist in the system.Please provide unique {Field}",
		"br" : "Uniqueness check for entered value"
	},
	{
		"code" : "BR-CAS-012",
		"message" : "People with age less than 75 cannot buy extended membership plan. Please select a different membership",
		"br" : "The system should check the member's age at the time of membership end date. If the member's age at the time of membership expiration is less than 75, then the member is not eligible for Extended Membership Plan."
	},
	{
		"code" : "BR-CAS-018",
		"message" : "The dependent will be over 26 years of age before the membership expires. Individual's age 26 and older are not eligible to be dependents in a family membership and require their own individual membership. You can enroll them after this membership enrollment is complete. For further information please contact Global Rescue Member Services at +1 617-459-4200.",
		"br" : "Checks if the dependent is eligible to be a part of family membership"
	},
	{
		"code" : "BR-CAS-019",
		"message" : "You have already added your spouse.",
		"br" : "Checks if the spouse for a family membership has already been added"
	},
	{
		"code" : "BR-CAS-020",
		"message" : "Maximum limit of 6 dependents has reached.",
		"br" : "Checks the number of dependents added"
	},
	{
		"code" : "BR-CAS-028",
		"message" : "People with ages 35 or more cannot buy student type membership. Please select a different membership or for further information contact. Member Services at +1 617-459-4200 email memberservices@globalrescue.com. ",
		"br" : "Age check for Student memberships"
	},
	{
		"code" : "BR-CAS-029",
		"message" : "{Field} is not unique in system",
		"br" : "Unique email address check for all the family members added."
	},
	{
		"code" : "BR-CAS-030",
		"message" : "Traveler must be less than equal 99 years of age to purchase travel insurance.",
		"br" : "Age check for travel insurance purchase"
	},
	{
		"code" : "BR-CAS-032",
		"message" : "We currently do not sell our {Field 1} plan in {Field 2}",
		"br" : "The system checks if the membership could be sold in the address provided by the user."
	},
	{
		"code" : "BR-CAS-037",
		"message" : "Referral discount is not applicable on selected membership.",
		"br" : "RP code discount application is allowed on following membership types: <br/> Travel Membership"
	},
	{
		"code" : "BR-CAS-049",
		"message" : "The given email address is blocked, please contact member services on +1 617-459-4200",
		"br" : "Black listed check for given email"
	},
	{
		"code" : "BR-CAS-200",
		"message" : "{Field} is mandatory",
		"br" : "The system should check if the value for this mandatory field has been entered or not."
	},
	{
		"code" : "BR-CAS-201",
		"message" : "{Field} format is invalid",
		"br" : "Field format is invalid"
	},
	{
		"code" : "BR-CAS-202",
		"message" : "{Field} is invalid",
		"br" : "Field value is invalid"
	},
	{
		"code" : "BR-CAS-204",
		"message" : "{Field 1} must be less than {Field 2}",
		"br" : "Provided value must be less than maximum limit for given parameter"
	},
	{
		"code" : "BR-CAS-205",
		"message" : "{Field 1} must be less than or equals to {Field 2}",
		"br" : "Provided value must be less than or equal to the maximum limit for given parameter"
	},
	{
		"code" : "BR-CAS-206",
		"message" : "{Field 1} must be greater than {Field 2}",
		"br" : "Provided value must be greater than the minimum limit for given parameter"
	},
	{
		"code" : "BR-CAS-207",
		"message" : "{Field 1} must be greater than or equals to {Field 2}",
		"br" : "Provided value must be greater than or equal to the minimum limit for given parameter"
	},
	{
		"code" : "BR-CAS-210",
		"message" : "{Field 1} length must be less than or equals to {Field 2}",
		"br" : "The length of provided value must be less than or equal to the maximum length for given parameter"
	},
	{
		"code" : "BR-CAS-212",
		"message" : "{Field 1} length must be greater than or equals to {Field 2}",
		"br" : "The length of provided value must be greater than or equal to the minimum length for given parameter"
	},
	{
		"code" : "BR-CAS-213",
		"message" : "{Field} must be in future",
		"br" : "The provided date must be in future"
	},
	{
		"code" : "BR-CAS-214",
		"message" : "{Field} must be in past",
		"br" : "The provided date must be in past"
	},
	{
		"code" : "BR-CAS-217",
		"message" : "{Field 1} length must be between {Field 2} and {Field 3}",
		"br" : "The length of provided value must be within the length limits for given parameter"
	},
	{
		"code" : "BR-CAS-219",
		"message" : "Your purchase has not been completed, the credit card information was declined by the credit card merchant. Please call your credit card merchant or enter a different credit card and try again.",
		"br" : "Credit Card declined by the merchant"
	},
	{
		"code" : "BR-CAS-220",
		"message" : "Sorry this membership can not be upgraded online. Please call Global rescue Member Services at +1 617-459-4200 for further information.",
		"br" : "Provided membership not upgradable"
	},
	{
		"code" : "BR-CAS-221",
		"message" : "Your purchase has not been completed, an unexpected error has occurred. Please try again or contact our help desk at +1 617-459-4200 for immediate assistance.",
		"br" : "Generic purchase exception"
	},
	{
		"code" : "BR-CAS-222",
		"message" : "Global Rescue only covers individuals up to the age of 85.",
		"br" : "Age of member greater than 85"
	},
	{
		"code" : "BR-CAS-223",
		"message" : "For age group 75-85, please download the extended membership application form from Global Rescue website and follow the provided instructions. For questions, please contact Global Rescue Member Services at +1 617-459-4200 or memberservices@globalrescue.com",
		"br" : "Member age between 75 and 85"
	},
	{
		"code" : "BR-CAS-224",
		"message" : "You can not upgrade a membership on its last day of membership. Date {Field}",
		"br" : "Upgrade a membership on last day of membership"
	},
	{
		"code" : "BR-CAS-225",
		"message" : "This contact already has medical device so renew package should not contain medical device.",
		"br" : "If a member already has a medical device during renew and system is requesting for a renew package with medical device"
	},
	{
		"code" : "BR-CAS-232",
		"message" : "Only 1 primary member is allowed",
		"br" : "Multiple primary members during a membership purchase"
	},
	{
		"code" : "BR-CAS-233",
		"message" : "Primary member is required",
		"br" : "No primary member during a membership purchase"
	},
	{
		"code" : "BR-CAS-234",
		"message" : "We are unable to process your travel insurance purchase at this moment, a representative from our member services team will contact you shortly.",
		"br" : "Generic travel insurance purchase error"
	},
	{
		"code" : "BR-CAS-235",
		"message" : "Cancel/Interrupt travel insurance is not available for New York state",
		"br" : "Travel insurance purchase error when selected plan is not available for given location"
	},
	{
		"code" : "BR-CAS-236",
		"message" : "Travel insurance is only available for resident of US",
		"br" : "Travel insurance purchase error when given location is out of US"
	},
	{
		"code" : "BR-CAS-238",
		"message" : "{Field} format is invalid for US",
		"br" : "Invalid zip code format"
	},
	{
		"code" : "BR-CAS-250",
		"message" : "{Field} has invalid key",
		"br" : "invalid JSON key"
	},
	{
		"code" : "BR-CAS-GENERAL",
		"message" : "{General Message}",
		"br" : "General system error"
	}

];
