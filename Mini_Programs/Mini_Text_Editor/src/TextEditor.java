import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class TextEditor extends JFrame implements ActionListener {

      JTextArea textArea;
      JScrollPane scrollPane;
      JSpinner fontSizeSpinner;
      JLabel fontSpinnerLabel;
      JButton fontColorButton;
      JComboBox fontBox;

      JMenuBar menuBar;
      JMenu fileMenu;
      JMenuItem openItem;
      JMenuItem saveItem;
      JMenuItem exitItem;

      TextEditor() {

            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setTitle("Text Editor");
            this.setSize(500, 500);
            this.setLayout(new FlowLayout());
            this.setLocationRelativeTo(null);  // To ensure the window opens in the center

// -----------   TEXT AREA --------------------------------------------------------------------------------------------------------------------------
            textArea = new JTextArea();
            textArea.setLineWrap(true); // To make sure text starts on a new line instead of continuing in one long line
            textArea.setFont(new Font("Arial", Font.BOLD, 20));

// -----------   SCROLL PANE --------------------------------------------------------------------------------------------------------------------------
            scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(450, 450));
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

// -----------   SPINNER / SIZE ADJUSTER --------------------------------------------------------------------------------------------------------------------------
            fontSpinnerLabel = new JLabel("Change size: ");

            fontSizeSpinner = new JSpinner();
            fontSizeSpinner.setPreferredSize(new Dimension(50, 25));
            fontSizeSpinner.setValue(20);
            fontSizeSpinner.addChangeListener(new ChangeListener() {
                  @Override
                  public void stateChanged(ChangeEvent e) {
                        textArea.setFont(new Font(textArea.getFont().getFamily(), Font.BOLD, (int) fontSizeSpinner.getValue()));
                  }
            });

// -----------   COLOR BUTTON ----------------------------------------------------------------------------------------------------------------------------
            fontColorButton = new JButton("Change color: ");
            fontColorButton.addActionListener(this);

            // This will create an array of all available fonts in Java:
            String[] fontsInJava = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

// -----------   FONT BOX ---------------------------------------------------------------------------------------------------------------------------
            fontBox = new JComboBox<>(fontsInJava);
            fontBox.addActionListener(this);
            fontBox.setSelectedItem("Arial");

// -----------   MENU BAR --------------------------------------------------------------------------------------------------------------------------
            menuBar = new JMenuBar();
            fileMenu = new JMenu("File");

            openItem = new JMenuItem("Open");
            openItem.addActionListener(this);

            saveItem = new JMenuItem("Save");
            saveItem.addActionListener(this);

            exitItem = new JMenuItem("Exit");
            exitItem.addActionListener(this);

            fileMenu.add(openItem);
            fileMenu.add(saveItem);
            fileMenu.add(exitItem);

            menuBar.add(fileMenu);
// -----------  / END /  MENU BAR --------------------------------------------------------------------------------------------------------------------------

            this.setJMenuBar(menuBar);
            this.add(fontSpinnerLabel);
            this.add(fontSizeSpinner);
            this.add(fontColorButton);
            this.add(fontBox);
            this.add(scrollPane);
            this.setVisible(true);

      }

      @Override
      public void actionPerformed(ActionEvent e) {

            if (e.getSource() == fontColorButton) {
                  JColorChooser colorChooser = new JColorChooser();

                  Color color = colorChooser.showDialog(null, "Pick a color: ", Color.BLUE);

                  textArea.setForeground(color);
            }

            if (e.getSource() == fontBox) {
                  textArea.setFont(new Font((String) fontBox.getSelectedItem(), Font.BOLD, textArea.getFont().getSize()));
            }

            if (e.getSource() == openItem) {
                  JFileChooser fileChooser = new JFileChooser();
                  fileChooser.setCurrentDirectory(new File("."));
                  FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
                  fileChooser.setFileFilter(filter);

                  int response = fileChooser.showOpenDialog(null);

                  if (response == JFileChooser.APPROVE_OPTION) {
                        File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                        Scanner fileIn = null;

                        try {
                              fileIn = new Scanner(file);
                              if (file.isFile()) {
                                    while (fileIn.hasNextLine()) {
                                          String line = fileIn.nextLine() + "\n";
                                          textArea.append(line);
                                    }
                              }
                        } catch (FileNotFoundException e1) {
                              e1.printStackTrace();
                        } finally {
                              fileIn.close();
                        }
                  }
            }

            if (e.getSource() == saveItem) {
                  JFileChooser fileChooser = new JFileChooser();
                  fileChooser.setCurrentDirectory(new File("."));

                  int response = fileChooser.showSaveDialog(null);

                  if (response == JFileChooser.APPROVE_OPTION) {
                        File file;
                        PrintWriter fileOut = null;

                        file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                        try {
                              fileOut = new PrintWriter(file);
                              fileOut.println(textArea.getText());
                        } catch (FileNotFoundException e1) {
                              e1.printStackTrace();
                        } finally {
                              fileOut.close();
                        }
                  }
            }

            if (e.getSource() == exitItem) {
                  System.exit(0);
            }
      }
}
