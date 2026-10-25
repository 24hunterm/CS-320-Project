# CS-320-Project
How can I ensure that my code, program, or software is functional and secure?

I can make sure my software is functional by testing it regularly and checking that it meets the project requirements. In the Contact Service project, I used JUnit tests to check that contacts could be created, updated, and managed correctly. I also tested invalid inputs, such as null values, phone numbers that did not contain exactly 10 digits, and names that exceeded the character limit. These tests helped me identify problems before they could affect the program. To improve security and reliability, I can also validate user input, handle errors properly, and review my code for potential weaknesses.

How do I interpret user needs and incorporate them into a program?

I start by reviewing the requirements and breaking them down into specific features that the program needs to support. For the Contact Service project, the requirements explained what information each contact needed and what restrictions applied to that information. For example, contact IDs had to be unique, names could not exceed 10 characters, and phone numbers had to contain exactly 10 digits. I used these requirements to guide the design of my Contact class and the tests I wrote. This approach helps ensure the finished program meets the user's expectations instead of relying on assumptions about how it should work.

How do I approach designing software?

I approach software design by understanding the requirements first and then breaking the program into smaller, manageable parts. In the Contact Service project, I separated the contact information and validation rules into the Contact class and used the ContactService class to manage operations such as adding, deleting, and updating contacts. I tested the code as I developed it, which made it easier to identify and fix problems early. In future projects, I plan to continue using this approach because it helps keep my code organized, makes testing easier, and reduces the chance of problems becoming harder to fix later.
