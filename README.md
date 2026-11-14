# Colombia GDP Viewer (JavaFX)

JavaFX desktop app that reads Colombia's GDP (PIB) by year from a MySQL database and shows it two ways:

- **Bar chart** of GDP per year
- **Table view** with every year and value

Coursework project (Java course assignment).

## Tech stack

Java, JavaFX (FXML), JDBC with MySQL Connector/J.

## Database

The app connects to a local MySQL database `javaassignment1` and reads table `pib_colombia` with columns `year` (int) and `gdp` (double):

```sql
CREATE TABLE pib_colombia (year INT PRIMARY KEY, gdp DOUBLE);
```

Connection settings are hard-coded for a local development database in `Controller.java` and `AllDataController.java`.

## Files

| File | Purpose |
|---|---|
| `Main.java` | Start screen with buttons for each view |
| `Controller.java` + `pib_colombia.fxml` | Bar chart view |
| `AllDataController.java` + `all_data_view.fxml` | Table view |
| `PIBData.java` | Year/GDP model |

Source files belong to package `com.example.assignment1`; the repository holds the sources only, without IDE or build files.
