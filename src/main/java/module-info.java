module com.example.databaseproject {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.databaseproject to javafx.fxml;
    exports com.example.databaseproject;
}