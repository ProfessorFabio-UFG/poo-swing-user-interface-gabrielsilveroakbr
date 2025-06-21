import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class FichaAvalaiacaoUI extends JFrame { // escrevi errado o nome do arquivo

    public FichaAvalaiacaoUI() {
        // Jframe
        super("Arquivo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 650);
        setLocationRelativeTo(null);

        // JmenuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu arquivoMenu = new JMenu("Arquivo");
        JMenu enviarSubMenu = new JMenu("Enviar");
        enviarSubMenu.add(new JMenuItem("email"));
        enviarSubMenu.add(new JMenuItem("impressora"));
        arquivoMenu.add(enviarSubMenu);
        arquivoMenu.add(new JMenuItem("Salvar"));
        arquivoMenu.add(new JMenuItem("Sair"));
        menuBar.add(arquivoMenu);
        setJMenuBar(menuBar);

        // Painel principal
        JPanel formContainer = new JPanel();
        formContainer.setLayout(new BoxLayout(formContainer, BoxLayout.Y_AXIS));
        formContainer.setBorder(new EmptyBorder(10, 10, 10, 10));


        //Adicionando os componentes no painel
        JLabel lblTitulo = new JLabel("Ficha de Avaliação");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza no BoxLayout
        formContainer.add(lblTitulo);
        formContainer.add(Box.createVerticalStrut(15)); // Espaçamento vertical

        // Campo "Código"
        formContainer.add(createLabelAndFieldPanel("Código:", new JTextField()));

        // Campo "Nome"
        formContainer.add(createLabelAndFieldPanel("Nome:", new JTextField()));
        
        // Campo "Sexo"
        //Painel com Checkbox
        JPanel sexoPanel = new JPanel(new BorderLayout(5, 5));
        sexoPanel.add(new JLabel("Sexo:"), BorderLayout.WEST);
        JRadioButton rbFeminino = new JRadioButton("Feminino");
        JRadioButton rbMasculino = new JRadioButton("Masculino");
        ButtonGroup sexoGroup = new ButtonGroup();
        sexoGroup.add(rbFeminino);
        sexoGroup.add(rbMasculino);
        JPanel checkBox = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        checkBox.add(rbFeminino); 
        checkBox.add(rbMasculino);
        sexoPanel.add(checkBox, BorderLayout.CENTER);
        sexoPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, sexoPanel.getPreferredSize().height)); // Evita que estique verticalmente
        formContainer.add(sexoPanel);
        
        formContainer.add(Box.createVerticalStrut(10));

        // Campo "Curriculum Vitae"
        // é só um J textarea centralizada centro-norte com tamanho de 10*20
        JPanel curriculumPanel = new JPanel(new BorderLayout());
        curriculumPanel.add(new JLabel("Curriculum Vitae"), BorderLayout.NORTH);
        JTextArea txtCurriculum = new JTextArea(10, 20);
        curriculumPanel.add(new JScrollPane(txtCurriculum), BorderLayout.CENTER);
        formContainer.add(curriculumPanel);

        formContainer.add(Box.createVerticalStrut(10));
        
        // Seção "Áreas"
        JPanel areasSectionPanel = new JPanel(new BorderLayout());
        areasSectionPanel.add(new JLabel("Áreas"), BorderLayout.NORTH);
        
        JPanel areasFieldsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        areasFieldsPanel.add(new JLabel("Interesse:"));
        areasFieldsPanel.add(new JComboBox<>(new String[]{"Desenvolvedor"}));
        areasFieldsPanel.add(new JLabel("Atuação:"));
        areasFieldsPanel.add(new JComboBox<>(new String[]{"Programação"}));
        areasSectionPanel.add(areasFieldsPanel, BorderLayout.CENTER);
        areasSectionPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, areasSectionPanel.getPreferredSize().height));
        formContainer.add(areasSectionPanel);

        // Botões embaixo
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(new JButton("Salvar"));
        buttonPanel.add(new JButton("Anterior"));
        buttonPanel.add(new JButton("Proximo"));
        buttonPanel.add(new JButton("Novo"));
        buttonPanel.add(new JButton("Cancelar"));

        // --- 6. Adição dos Painéis ao Frame Principal ---
        // O layout do JFrame por padrão já é BorderLayout
        getContentPane().add(formContainer, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }
    private JPanel createLabelAndFieldPanel(String labelText, JComponent component) {
        JPanel panel = new JPanel(new BorderLayout(5, 5)); // 5px de espaçamento
        panel.add(new JLabel(labelText), BorderLayout.WEST);
        panel.add(component, BorderLayout.CENTER);
        
        // Limita a altura máxima para evitar que o painel estique verticalmente no BoxLayout
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, panel.getPreferredSize().height));
        
        return panel;
    }
    public static void main(String[] args) {
        FichaAvalaiacaoUI frame = new FichaAvalaiacaoUI();
            frame.setVisible(true);
    }
}
