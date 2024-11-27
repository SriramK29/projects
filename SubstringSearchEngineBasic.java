import java.awt.*;
import java.awt.event.*;

public class SubstringSearchEngineBasic extends Frame {
    
    // Array to hold documents
    private String[] documents = new String[10]; // Limit of 10 documents for simplicity
    private int docCount = 0;

    // GUI components
    private TextField inputField;
    private TextArea textArea;
    private Button addButton, searchButton, clearButton;

    public SubstringSearchEngineBasic() {
        setLayout(new FlowLayout());
        setTitle("Basic Substring Search Engine");
        setSize(500, 400);  // Increase window size for better display

        // Create components
        inputField = new TextField(30);
        textArea = new TextArea(20, 60);  // Increase rows to 20 and columns to 60 for larger output box
        textArea.setEditable(false);
        addButton = new Button("Add Document");
        searchButton = new Button("Search");
        clearButton = new Button("Clear");

        // Add components to frame
        add(inputField);
        add(addButton);
        add(searchButton);
        add(clearButton);
        add(textArea);

        // Button event for adding documents
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String content = inputField.getText();
                if (!content.isEmpty() && docCount < documents.length) {
                    // Create dynamic document name (Document 1, Document 2, etc.)
                    String documentName = "Document " + (docCount + 1);
                    documents[docCount++] = documentName + ": " + content; // Store document with name
                    textArea.append("Document added: " + documentName + "\n");
                    inputField.setText(""); // Clear input field after adding
                }
            }
        });

        // Button event for searching in documents
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String query = inputField.getText();
                if (!query.isEmpty()) {
                    boolean found = false;
                    textArea.append("Searching for: " + query + "\n");
                    // Search through the documents array
                    for (int i = 0; i < docCount; i++) {
                        if (documents[i].toLowerCase().contains(query.toLowerCase())) {
                            textArea.append("Found in " + documents[i] + "\n");
                            found = true;
                        }
                    }
                    if (!found) {
                        textArea.append("No matches found.\n");
                    }
                    inputField.setText(""); // Clear the search field after searching
                }
            }
        });

        // Button event for clearing the text area and resetting document list
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText(""); // Clear the text area
                docCount = 0; // Reset document count
                for (int i = 0; i < documents.length; i++) {
                    documents[i] = null; // Clear the document array
                }
                textArea.append("All documents cleared.\n");
            }
        });

        // Window closing behavior
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new SubstringSearchEngineBasic();
    }
}