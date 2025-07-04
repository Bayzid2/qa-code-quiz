# QA Testing Quiz
qa-code-quiz/<br>
│
├── API Test/<br>
--- └── apiTesting Using Postman & Newman<br>
--------├── MeldCX quiz API test.postman_collection.json<br>
--------└── Newman <br>
--------------└── MeldCX quiz API test-2025-07-01-16-39-17-015-0.html       #Newman html report<br>
---└── apiTestsuing RestAssured/src/test/java/meldCX_API_testing/apiTest/    #Automated API tests<br>
│<br>
├── cypress/<br>
-------└── e2e/<br>
 -------------└── qa_quiz.cy.js # UI test for login page<br>


## 🛠 Tools & Technologies Used

- **Postman**
- **Newman**
- **RestAssured**
- - **Java**, - **Java**, **Maven**
- **Cypress**
---
## 🔹 1. Postman – Manual API Testing
-Newman for generate html report
```bash
newman run <collection-file> -e <environment-file> -r html


## 🔹 2. RestAssured – Automated API Testing

**📂 Location:**  
`API Test/apiTestsuing RestAssured/src/test/java/meldCX_API_testing/apiTest/`

**🧰 Pre-requisites:**

- Java 11+
- Maven installed
- TestNG
## 🔹 3. Cypress – UI Testing
**🧰 Pre-requisites:**

- Node.js
- npm installed

---

**📦 Install Cypress:**

```bash
npm install

** Run Cypress tests
```bash
npx cypress open


### Scenario
The frontend team has developed a prototype login portal for an up and coming platform.
However, they have not implemented any testing yet and it is up to you to do so.

As the QA developer, what is tested and how it is tested is up to you.
Management simply asks that these tests provide as much evidence as possible of the platform's reliability.

### Notes
- Submission must include a link to a public fork/clone of this repository
- We typically use Jest for testing node.js/API related logic and Cypress for testing UI functionality, however, you are more than welcome to use any testing framework you desire so long as you are able to provide reasonable justification
