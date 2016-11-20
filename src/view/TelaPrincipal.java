package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.*;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import model.Curso;
import model.Disciplina;
import model.Professor;
import model.ProfessorDisciplina;
import projeto.Controller;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel pnlBdState, pnlInput, pnlProf, pnlDisciplina, pnlRelacao;
	private JButton btnInserir;
	private JButton btnExcluir;
	private JButton btnAlterar, btnLimpar;
	private JTextArea codigo;
	private JTextField txtDescOperacao;
	private Controller ctrl;
	private JTabbedPane tb;
	
	private JTextField[] campos;
	private JLabel[] lbls;
	
	private JComboBox<Curso> slCurso;
	private JComboBox<Professor> slProf;
	private JComboBox<Disciplina> slDisc;

	private JTable prof;
	private JTable disc;
	private JTable p_di;
	
	private JDatePickerImpl dt_nasc, dt_contrat;

	public TelaPrincipal() {
		campos = new JTextField[TxtFieldIndex.values().length];
		lbls = new JLabel[TxtFieldIndex.values().length];
		for(int i=0; i<campos.length; i++){
			campos[i]=new JTextField();
			lbls[i]=new JLabel(TxtFieldIndex.values()[i].getLbl());
		}
		
		SqlDateModel model = new SqlDateModel();
		Properties p = new Properties();
		p.put("text.today", "Hoje");
		p.put("text.month", "M�s");
		p.put("text.year", "Ano");
		JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
		dt_nasc = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
		model = new SqlDateModel();
		datePanel = new JDatePanelImpl(model,p);
		dt_contrat = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	}

	public void iniciarComponentes(ArrayList<Professor> profs, ArrayList<Disciplina> disciplinas,
			ArrayList<Curso> curso, ArrayList<ProfessorDisciplina> profDis) {
		// Criando a janela
		this.setTitle("Projeto Universidade");
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1100, 680);
		
		// Criando os paineis
		JPanel upperPanel = new JPanel();
		upperPanel.setLayout(new BoxLayout(upperPanel,BoxLayout.Y_AXIS));
		upperPanel.setPreferredSize(new Dimension(1020,400));
		
		JPanel lowerPanel = new JPanel();
		lowerPanel.setLayout(new BoxLayout(lowerPanel,BoxLayout.X_AXIS));
		lowerPanel.setPreferredSize(new Dimension(1020,300));
		
		pnlBdState = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		pnlBdState.setBorder(BorderFactory.createTitledBorder("Banco de Dados"));
		//pnlComandos.setPreferredSize(new Dimension( 580, 300));
		pnlBdState.setVisible(true);
		
		prof = new JTable(new ProfessorModel(profs));
		disc = new JTable(new DisciplinaModel(disciplinas));
		p_di = new JTable(new ProfDiscModel(profDis));
		
		prof.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		disc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		p_di.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		prof.getSelectionModel().addListSelectionListener(ctrl);
		disc.getSelectionModel().addListSelectionListener(ctrl);
		p_di.getSelectionModel().addListSelectionListener(ctrl);
		
		tb = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		tb.setPreferredSize(new Dimension(1020,300));
		tb.addTab("Professor", prof);
		tb.addTab("Disciplina", disc);
		tb.addTab("Professor pode dar Disciplina", p_di);
		tb.addChangeListener(ctrl);
		pnlBdState.add(tb);
		
		//LOWER PANEL
		pnlInput = new JPanel();
		pnlInput.setPreferredSize(new Dimension(950,300));
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(4,1));
		GridLayout g = new GridLayout(4,1);
		g.setVgap(10);
		buttons.setLayout(g);
		
		buttons.setPreferredSize(new Dimension(100,300));
		
		btnInserir = new JButton("Inserir");
		btnExcluir = new JButton("Excluir");
		btnAlterar = new JButton("Alterar");
		btnLimpar = new JButton("Limpar");
		
		btnInserir.setActionCommand("inserir");
		btnExcluir.setActionCommand("excluir");
		btnAlterar.setActionCommand("alterar");
		btnLimpar.setActionCommand("limpar");
		
		btnInserir.addActionListener(ctrl);
		btnExcluir.addActionListener(ctrl);
		btnAlterar.addActionListener(ctrl);
		btnLimpar.addActionListener(ctrl);
		
		btnInserir.setAlignmentX(CENTER_ALIGNMENT);
		btnAlterar.setAlignmentX(CENTER_ALIGNMENT);
		btnExcluir.setAlignmentX(CENTER_ALIGNMENT);
		btnLimpar.setAlignmentX(CENTER_ALIGNMENT);
		
		buttons.add(btnInserir);
		
		buttons.add(btnAlterar);
		buttons.add(btnExcluir);
		buttons.add(btnLimpar);
		
		buttons.setBorder(BorderFactory.createTitledBorder("A��es"));
		
		upperPanel.add(pnlBdState);
		
		lowerPanel.add(pnlInput);
		lowerPanel.add(buttons);
		
		this.add(upperPanel);
		this.add(lowerPanel);
		
		pnlRelacao = new JPanel();
		
		JPanel aux1, aux2;
		
		aux1 = new JPanel();
		aux1.setLayout(new FlowLayout());
		
		JLabel lblProfs = new JLabel("Professor: ");
		slProf = new JComboBox<Professor>();
		slProf.setPreferredSize(new Dimension(100, 20));
		
		aux1.add(lblProfs);
		aux1.add(slProf);
		
		aux2 = new JPanel();
		aux2.setLayout(new FlowLayout());
		
		JLabel lblDiscs = new JLabel("Disciplina: ");
		slDisc = new JComboBox<Disciplina>();
		slDisc.setPreferredSize(new Dimension(100, 20));
		
		aux1.add(lblProfs);
		aux1.add(slProf);
		
		aux2.add(lblDiscs);
		aux2.add(slDisc);
		
		pnlRelacao.setLayout(new BoxLayout(pnlRelacao, BoxLayout.X_AXIS));
		pnlRelacao.add(aux1);
		pnlRelacao.add(aux2);
		
		pnlProf = new JPanel();
		g = new GridLayout(4,4);
		g.setHgap(10);
		g.setVgap(10);
		pnlProf.setLayout(g);
		
		
		aux1 = new JPanel(); //1
		aux1.setLayout(new BoxLayout(aux1,BoxLayout.Y_AXIS));
		aux1.add(lbls[TxtFieldIndex.CPF.ordinal()]);
		aux1.add(campos[TxtFieldIndex.CPF.ordinal()]);
		
		pnlProf.add(aux1);
		
		aux1 = new JPanel();//2
		aux1.setLayout(new BoxLayout(aux1,BoxLayout.Y_AXIS));
		aux1.add(lbls[TxtFieldIndex.EMAIL.ordinal()]);
		aux1.add(campos[TxtFieldIndex.EMAIL.ordinal()]);
		
		pnlProf.add(aux1);
		
		aux1 = new JPanel();//1
		aux1.setLayout(new BoxLayout(aux1,BoxLayout.Y_AXIS));
		aux1.add(lbls[TxtFieldIndex.NOME_PROF.ordinal()]);
		aux1.add(campos[TxtFieldIndex.NOME_PROF.ordinal()]);
		
		pnlProf.add(aux1);
		
		aux1 = new JPanel();//2
		aux1.setLayout(new BoxLayout(aux1,BoxLayout.Y_AXIS));
		aux1.add(lbls[TxtFieldIndex.TEL.ordinal()]);
		aux1.add(campos[TxtFieldIndex.TEL.ordinal()]);
		
		pnlProf.add(aux1);
		
		aux1 = new JPanel();//1
		aux1.setLayout(new BoxLayout(aux1,BoxLayout.Y_AXIS));
		aux1.add(lbls[TxtFieldIndex.EMAIL_PROF.ordinal()]);
		aux1.add(campos[TxtFieldIndex.EMAIL_PROF.ordinal()]);
		
		pnlProf.add(aux1);
		
		aux1 = new JPanel();//2
		aux1.setLayout(new BoxLayout(aux1,BoxLayout.Y_AXIS));
		aux1.add(lbls[TxtFieldIndex.CEP.ordinal()]);
		aux1.add(campos[TxtFieldIndex.CEP.ordinal()]);
		
		pnlProf.add(aux1);
		
		aux1 = new JPanel();//1
		aux1.setLayout(new BoxLayout(aux1,BoxLayout.Y_AXIS));
		aux1.add(lbls[TxtFieldIndex.LOGRADOURO.ordinal()]);
		aux1.add(campos[TxtFieldIndex.LOGRADOURO.ordinal()]);
		
		pnlProf.add(aux1);
		
		aux1 = new JPanel();//2
		aux1.setLayout(new BoxLayout(aux1,BoxLayout.Y_AXIS));
		aux1.add(lbls[TxtFieldIndex.NUM.ordinal()]);
		aux1.add(campos[TxtFieldIndex.NUM.ordinal()]);
		
		pnlProf.add(aux1);
		
		aux1 = new JPanel();//1
		aux1.setLayout(new BoxLayout(aux1,BoxLayout.Y_AXIS));
		aux1.add(lbls[TxtFieldIndex.COMPLEMENTO.ordinal()]);
		aux1.add(campos[TxtFieldIndex.COMPLEMENTO.ordinal()]);
		
		pnlProf.add(aux1);
		
		aux1 = new JPanel();//2
		aux1.setLayout(new BoxLayout(aux1,BoxLayout.Y_AXIS));
		aux1.add(lbls[TxtFieldIndex.STATUS.ordinal()]);
		aux1.add(campos[TxtFieldIndex.STATUS.ordinal()]);
		
		pnlProf.add(aux1);
		
		aux1 = new JPanel();//1
		aux1.setLayout(new BoxLayout(aux1,BoxLayout.Y_AXIS));
		aux1.add(lbls[TxtFieldIndex.RG.ordinal()]);
		aux1.add(campos[TxtFieldIndex.RG.ordinal()]);
		
		pnlProf.add(aux1);
		
		aux1 = new JPanel();//2
		aux1.setLayout(new BoxLayout(aux1,BoxLayout.Y_AXIS));
		aux1.add(lbls[TxtFieldIndex.CURR.ordinal()]);
		aux1.add(campos[TxtFieldIndex.CURR.ordinal()]);
		
		pnlProf.add(aux1);
		//12 pra cima
		
		aux1 = new JPanel();//1
		aux1.setLayout(new BoxLayout(aux1,BoxLayout.Y_AXIS));
		aux1.add(lbls[TxtFieldIndex.DT_NASC.ordinal()]);
		aux1.add(dt_nasc);
		
		pnlProf.add(aux1);
		
		aux1 = new JPanel();//2
		aux1.setLayout(new BoxLayout(aux1,BoxLayout.Y_AXIS));
		aux1.add(lbls[TxtFieldIndex.DT_CONTRATACAO.ordinal()]);
		aux1.add(dt_contrat);
		
		pnlProf.add(aux1);
		
		aux1 = new JPanel();//1
		aux1.setLayout(new BoxLayout(aux1,BoxLayout.Y_AXIS));
		aux1.add(lbls[TxtFieldIndex.CURSO.ordinal()]);
		slCurso = new JComboBox<Curso>();
		slCurso.setPreferredSize(new Dimension(100, 20));
		aux1.add(slCurso);
		
		pnlProf.add(aux1);
		
		pnlDisciplina = new JPanel();
		g = new GridLayout(2,4);
		g.setHgap(10);
		g.setVgap(10);
		pnlDisciplina.setLayout(g);
		
		aux1 = new JPanel();//1
		aux1.setLayout(new BoxLayout(aux1,BoxLayout.Y_AXIS));
		aux1.add(lbls[TxtFieldIndex.ID_DISC.ordinal()]);
		aux1.add(campos[TxtFieldIndex.ID_DISC.ordinal()]);
		
		pnlDisciplina.add(aux1);
		
		aux1 = new JPanel();//2
		aux1.setLayout(new BoxLayout(aux1,BoxLayout.Y_AXIS));
		aux1.add(lbls[TxtFieldIndex.NOME_DISC.ordinal()]);
		aux1.add(campos[TxtFieldIndex.NOME_DISC.ordinal()]);
		
		pnlDisciplina.add(aux1);
		
		aux1 = new JPanel();//1
		aux1.setLayout(new BoxLayout(aux1,BoxLayout.Y_AXIS));
		aux1.add(lbls[TxtFieldIndex.SIGLA.ordinal()]);
		aux1.add(campos[TxtFieldIndex.SIGLA.ordinal()]);
		
		pnlDisciplina.add(aux1);
		
		aux1 = new JPanel();//2
		aux1.setLayout(new BoxLayout(aux1,BoxLayout.Y_AXIS));
		aux1.add(lbls[TxtFieldIndex.EMENTA.ordinal()]);
		aux1.add(campos[TxtFieldIndex.EMENTA.ordinal()]);
		
		pnlDisciplina.add(aux1);
		
		aux1 = new JPanel();//1
		aux1.setLayout(new BoxLayout(aux1,BoxLayout.Y_AXIS));
		aux1.add(lbls[TxtFieldIndex.CRED_AULA.ordinal()]);
		aux1.add(campos[TxtFieldIndex.CRED_AULA.ordinal()]);
		
		pnlDisciplina.add(aux1);
		
		aux1 = new JPanel();//2
		aux1.setLayout(new BoxLayout(aux1,BoxLayout.Y_AXIS));
		aux1.add(lbls[TxtFieldIndex.CRED_TRAB.ordinal()]);
		aux1.add(campos[TxtFieldIndex.CRED_TRAB.ordinal()]);
		
		pnlDisciplina.add(aux1);
		
		aux1 = new JPanel();//1
		aux1.setLayout(new BoxLayout(aux1,BoxLayout.Y_AXIS));
		aux1.setPreferredSize(new Dimension(200,50));
		aux1.add(lbls[TxtFieldIndex.PER_IDEAL.ordinal()]);
		aux1.add(campos[TxtFieldIndex.PER_IDEAL.ordinal()]);
		
		pnlDisciplina.add(aux1);
		
		//pnlInput.add(pnlRelacao);
		
		
		/*pnlLinhasControle = new JPanel();
		pnlLinhasControle.setLayout(new BoxLayout(pnlLinhasControle, BoxLayout.Y_AXIS));
		pnlLinhasControle.setBorder(BorderFactory.createTitledBorder("Linhas de Controle"));
		pnlLinhasControle.setPreferredSize(new Dimension( 580, 300));
		pnlLinhasControle.setVisible(true);
		
		leftPanel.add(pnlComandos, BorderLayout.LINE_START);
		leftPanel.add(pnlLinhasControle, BorderLayout.CENTER);
		this.getContentPane().add(leftPanel, BorderLayout.LINE_START);
		
		pnlRegistradores = new JPanel(new FlowLayout());
		pnlRegistradores.setBorder(BorderFactory.createTitledBorder("Registradores"));
		pnlRegistradores.setPreferredSize(new Dimension( 380, 300));
		pnlRegistradores.setVisible(true);
		GridLayout g = new GridLayout(0,4);
		g.setVgap(10);
		JPanel regs = new JPanel(g);
		regs.setPreferredSize(new Dimension( 500, 240));
		pnlRegistradores.add(regs);
		((FlowLayout)pnlRegistradores.getLayout()).setAlignment(FlowLayout.LEFT);
		
		pnlMemoria = new JPanel(new BorderLayout());
		pnlMemoria.setBorder(BorderFactory.createTitledBorder("Memória"));
		pnlMemoria.setPreferredSize(new Dimension(380, 300));
		pnlMemoria.setVisible(true);
		
		rightPanel.add(pnlRegistradores, BorderLayout.LINE_START);
		rightPanel.add(pnlMemoria, BorderLayout.CENTER);
		this.getContentPane().add(rightPanel, BorderLayout.CENTER);
		
		//Criando Compoenentes para os comandos
		JPanel p = new JPanel(new BorderLayout());
		p.setPreferredSize(new Dimension(545,200));
		codigo = new JTextArea("");
		codigo.setLineWrap(true);
		codigo.setWrapStyleWord(true);
		JScrollPane scrollCodigo = new JScrollPane(codigo);
		scrollCodigo.setPreferredSize(new Dimension(545, 200));
		scrollCodigo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		p.add(scrollCodigo,BorderLayout.PAGE_START);
		
		btnTraduzir = new JButton("Traduzir");
		btnTraduzir.setActionCommand("Traduzir");
		btnTraduzir.addActionListener(ctrl);
		btnTraduzir.setSize(50, 20);
		
		btnExecutaInstrucao = new JButton("Executa Instrução");
		btnExecutaInstrucao.setActionCommand("Executar");
		btnExecutaInstrucao.addActionListener(ctrl);
		btnExecutaInstrucao.setSize(50, 20);
		
		btnClearCodigo = new JButton("Limpar Memória");
		btnClearCodigo.setActionCommand("Limpar");
		btnClearCodigo.addActionListener(ctrl);
		btnClearCodigo.setSize(50, 20);
		
		pnlComandos.add(p);
		pnlComandos.add(btnTraduzir);
		pnlComandos.add(btnExecutaInstrucao);
		pnlComandos.add(btnClearCodigo);
		
		//Criando componentes para as linhas de controle
		JPanel descLinhaControle = new JPanel(new BorderLayout());
		descLinhaControle.setPreferredSize(new Dimension(545,30));
		this.txtDescOperacao = new JTextField();
		txtDescOperacao.setEditable(false);
		descLinhaControle.add(txtDescOperacao);
		tabelaControle = new JTable();
		//tabelaControle.getColumnModel().getColumn(0).setPreferredWidth(460);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		/*rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tabelaControle.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
		tabelaControle.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
		tabelaControle.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
		tabelaControle.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		tabelaControle.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
		tabelaControle.setEnabled(false);*/
        //JScrollPane barraRolagem = new JScrollPane(tabelaControle);
        /*
        pnlLinhasControle.add(descLinhaControle); 
        pnlLinhasControle.add(barraRolagem); 
		
		tabelaMemoria = new JTable();
		tabelaMemoria.setEnabled(false);
        JScrollPane barraRolagemMemoria = new JScrollPane(tabelaMemoria);
        
        JPanel jmpMemPanel = new JPanel(new FlowLayout());
        pnlMemoria.add(jmpMemPanel, BorderLayout.NORTH);
        pnlMemoria.add(barraRolagemMemoria, BorderLayout.CENTER);
        
        //Criando Componentes para os registradores
        txtRegistradores = new JTextField[17];
        JLabel[] lblRegs = new JLabel[17];
        String[] nomesRegs = new String[]{"ax", "bx", "cx", "dx", "ir", "p1", "p2", "pc",  "ds", "mar", "mbr", "x","ac","UL1", "UL2", "Zero", "Sinal"};
        JPanel aux;
        for(int i = 0; i <= 16; i++){
        	aux = new JPanel();
        	aux.setLayout(new BoxLayout(aux,BoxLayout.X_AXIS));
        	txtRegistradores[i] = new JTextField();
        	txtRegistradores[i].setPreferredSize(new Dimension(55,30));
        	txtRegistradores[i].setEditable(false);
        	lblRegs[i] = new JLabel(nomesRegs[i].toUpperCase());
        	lblRegs[i].setPreferredSize(new Dimension(30,30));
        	if(i>14)
        		lblRegs[i].setPreferredSize(new Dimension(40,30));
        	aux.add(lblRegs[i]);
        	aux.add(txtRegistradores[i]);
        	regs.add(aux);
        	if(i == 6){
        		regs.add(new JPanel()); //pra encher o espaço xD
        	} else if(i==8 || i==10 || i==12){
        		regs.add(new JPanel()); //pra encher o espaço xD
        		regs.add(new JPanel()); //pra encher o espaço xD
        	}
        }
        */
		this.setVisible(true);
	}
	
	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	public JTabbedPane getTb() {
		return tb;
	}

	//utilizado pela Controller para atualizar a linha atual do firmware
	public void atualizaSelecaoLinhaControle(int ponteiro) {
		//tabelaControle.setRowSelectionInterval(ponteiro, ponteiro);
		//tabelaControle.scrollRectToVisible(new Rectangle(tabelaControle.getCellRect(ponteiro, 0, true)));
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
/*
	public JPanel getPnlComandos() {
		return pnlComandos;
	}

	public JPanel getPnlRegistradores() {
		return pnlRegistradores;
	}

	public JPanel getPnlMemoria() {
		return pnlMemoria;
	}

	public JPanel getPnlLinhasControle() {
		return pnlLinhasControle;
	}
*/
	public JPanel getPnlInput(){
		return pnlInput;
	}

	public JTextArea getCodigo() {
		return codigo;
	}

	public JButton getBtnInserir() {
		return btnInserir;
	}

	public JButton getBtnExcluir() {
		return btnExcluir;
	}

	public JButton getBtnAlterar() {
		return btnAlterar;
	}

	/*seta o TableModel da tabela que representa a memória
	public void setMemoryModel(Object memoria) {
		this.tabelaMemoria.setModel(new MemoriaModel(memoria));
		tabelaMemoria.getColumnModel().getColumn(0).setPreferredWidth(70);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tabelaMemoria.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
		tabelaMemoria.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
	}
	
	//atualiza o modelo da tabela de memória, para que ele busque as atualizações nos valores e posições preenchidos
	public void atualizaMem() {
		((MemoriaModel)this.tabelaMemoria.getModel()).update();
		tabelaMemoria.repaint();
		tabelaMemoria.revalidate();
	}*/

	public JTextField getTxtDescOperacao() {
		return txtDescOperacao;
	}

	public JDatePicker getDt_nasc() {
		return dt_nasc;
	}

	public JDatePicker getDt_contrat() {
		return dt_contrat;
	}

	public JComboBox<Curso> getSlCurso() {
		return slCurso;
	}

	public void setSlCurso(JComboBox<Curso> slCurso) {
		this.slCurso = slCurso;
	}

	public JPanel getPnlDisciplina() {
		return pnlDisciplina;
	}

	public void setPnlDisciplina(JPanel pnlDisciplina) {
		this.pnlDisciplina = pnlDisciplina;
	}
	
}
