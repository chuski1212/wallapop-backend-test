Things to improve:
- For this exercise I´m assuming the initial configuration POST body will be correct, but a next step will be adding validation.
- Add token authorization to protect endpoints.
- Return a DTO instead of the whole entity from the repository. Then we´ll manage to:
    - Just fetch required data from the database, avoiding possible extra queries.
    - Hide unnecessary entity attributes for the repository user, we´ll only send the needed values.