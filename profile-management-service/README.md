# Profile Management Service
The Profile Management Service handles the creation and management of user profiles.

## Base Method
**createProfile()**:

This method is used to create a new user profile, collecting essential details and verifying the user's identity.

## Responsibilities
The Profile Management Service is responsible for the following tasks:

- Collecting additional user details such as contact information, employment status, income, and any other necessary information to create a comprehensive user profile.
- Verifying the user's identity through a robust document verification process to ensure the authenticity of the provided information.
- Securely storing the user profile information in the database.
- Providing options for users to update or modify their profile information as needed.


# Profile Management Service API

## API Endpoints

### Update Contact Information

Updates the contact information for a user profile.

- Endpoint: PUT /api/profile/contact-information
- Request Headers:
    - Authorization: Bearer your-access-token
- Request Body:
  ```json
  {
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "phoneNumber": "+1234567890"
  }

- Response:
````json
 {
  "status": "success",
  "data": {
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "phoneNumber": "+1234567890"
  }
  }
