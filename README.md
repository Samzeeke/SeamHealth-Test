
Automated Testing:
Automated User Login:
Tool/Framework: Selenium WebDriver with a testing framework 

Steps:
Open the Clientshot Webpage
Enter the provided email and password
Click the login button
Expected Outcome: Successfully logs in; validate the user dashboard or profile page.
Actual Outcome : Login Successful, validated the user dashboard 


Automated Feedback Export (Complaints):
Steps:
Navigate to the feedback section
Select 'Complaints'
Click on the export button
Expected Outcome: The export functionality works correctly, and the exported file can be verified in both csv and excel.
Actual Outcome :  Could not download, due to endpoint failing Request URL:
https://ps-dev-api.seamhealth.support/api/auth/complaint/contact/export?jobFormat=CSV&jobType=COMPLAINT_EXPORT&startDate=2024-00-15&endDate=2024-01-15
Request Method:
GET
Status Code:
400 Bad Request








API AUTOMATION 

# Base URL for the API
base_url = "https://bridge-dev-api.seamhealth.support"

# User credentials
email = "imodupsy@mailinator.com"
password = "password"

# Authenticate user and get the token
def authenticate_user():
    auth_url = f"{base_url}/api/authenticate"
    auth_data = {"email": email, "password": password}
    response = requests.post(auth_url, data=auth_data)
    token = response.json().get("token")
    return token

# Set the token for authorization
headers = {"Authorization": f"Bearer {authenticate_user()}"}

# API endpoints for the scenarios
register_patient_url = f"{base_url}/api/patients/registerPatient"
export_patient_url = f"{base_url}/api/patients/exportPatient"
update_patient_url = f"{base_url}/api/patients/updatePatient"

# Scenario: Register Patient
def register_patient():
    marital_status = "MARRIED"  # You can choose the appropriate marital status
    register_data = {"maritalStatus": marital_status}
    response = requests.post(register_patient_url, headers=headers, data=json.dumps(register_data))
    print(response.json())

# Scenario: Export Patient
def export_patient():
    job_type = "PATIENT_EXPORT"
    job_format = "CSV"
    export_data = {"jobType": job_type, "jobFormat": job_format}
    response = requests.get(export_patient_url, headers=headers, params=export_data)
    print(response.json())

# Scenario: Update Patient
def update_patient():
    new_email = "new_email@mailinator.com"
    new_marital_status = "SINGLE"
    update_data = {"email": new_email, "maritalStatus": new_marital_status}
    response = requests.post(update_patient_url, headers=headers, data=json.dumps(update_data))
    print(response.json())

# Run the scenarios
register_patient()
export_patient()
update_patient()

