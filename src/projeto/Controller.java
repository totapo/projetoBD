package projeto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import view.TelaPrincipal;
import model.*;

public class Controller implements ActionListener, ListSelectionListener, ChangeListener{
	private TelaPrincipal tela;
	
	public Controller(){
		
		tela = new TelaPrincipal();
		tela.iniciarComponentes(null,null,null,null);
		//tela.getBtnExecutaInstrucao().setEnabled(false);
		//tela.getBtnClearCodigo().setEnabled(false);
		this.atualizarExibicao();
		
	}
	
	//atualiza os campos da tela com os valores dos componetes
	private void atualizarExibicao() {
		/*
		tela.getTxtRegistradores()[tela.mar].setText(mar.getPalavra().getIntValue()+"");
		tela.getTxtRegistradores()[tela.mbr].setText(mbr.getPalavra().getIntValue()+"");
		tela.getTxtRegistradores()[tela.ir].setText(ir.getPalavra().getIntValue()+"");
		tela.getTxtRegistradores()[tela.p1].setText(p1.getPalavra().getIntValue()+"");
		tela.getTxtRegistradores()[tela.p2].setText(p2.getPalavra().getIntValue()+"");
		tela.getTxtRegistradores()[tela.pc].setText(pc.getPalavra().getIntValue()+"");
		tela.getTxtRegistradores()[tela.ax].setText(ax.getPalavra().getIntValue()+"");
		tela.getTxtRegistradores()[tela.bx].setText(bx.getPalavra().getIntValue()+"");
		tela.getTxtRegistradores()[tela.cx].setText(cx.getPalavra().getIntValue()+"");
		tela.getTxtRegistradores()[tela.dx].setText(dx.getPalavra().getIntValue()+"");
		tela.getTxtRegistradores()[tela.ds].setText(ds.getPalavra().getIntValue()+"");
		
		tela.getTxtRegistradores()[tela.x].setText(x.getPalavra().getIntValue()+"");
		tela.getTxtRegistradores()[tela.ac].setText(ac.getPalavra().getIntValue()+"");
		
		tela.getTxtRegistradores()[tela.ula1].setText(ula.getNum1().getIntValue()+"");
		tela.getTxtRegistradores()[tela.ula2].setText(ula.getNum2().getIntValue()+"");
		
		tela.getTxtRegistradores()[tela.zero].setText(((ula.flagZero())?1:0)+"");
		tela.getTxtRegistradores()[tela.sinal].setText(((ula.flagSignal())?1:0)+"");
		
		tela.atualizaSelecaoLinhaControle(UC.getPointer());

		tela.getTxtDescOperacao().setText("Linha "+UC.getPointer()+": "+Firmware.instrucoes[UC.getPointer()].getDesc());
		
		tela.atualizaMem();*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		/*
		switch(action){
		case "Traduzir": //botao traduzir
			try {
				if(tela.getCodigo().getText().trim().length()>0){
					this.traduzir(tela.getCodigo().getText());
					//só deixa os outros botões ativos se traduziu corretamente
					//tela.getBtnExecutaInstrucao().setEnabled(true);
					//tela.getBtnClearCodigo().setEnabled(true);
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(tela, ex.getClass().getName()+": "+ex.getMessage(), "Erro na tradução", JOptionPane.ERROR_MESSAGE);
				//ex.printStackTrace();
			}
			break;
		case "Executar": //botao executar
			try {
				//UC.advanceClock();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(tela, ex.getClass().getName()+": "+ex.getMessage(), "Erro na execução", JOptionPane.ERROR_MESSAGE);
				//ex.printStackTrace();
			}
			break;
		case "Limpar": //botao limpar
			//tela.getBtnExecutaInstrucao().setEnabled(false);
			//tela.getBtnClearCodigo().setEnabled(false);
			resetAll();
			break;
		default:
		}
		atualizarExibicao();*/
	}

	//reseta o status de todos os componentes
	private void resetAll() {
		/*
		UC.reset();;
		memoria.reset();;
		ula.reset();
		mar.reset();
		mbr.reset();
		ir.reset();
		p1.reset();
		p2.reset();
		x.reset();
		ac.reset();
		pc.reset();
		ax.reset();
		bx.reset();
		cx.reset();
		dx.reset();
		ds.reset();*/
	}

	private void traduzir(String text) throws Exception {
		String[] linhas = text.split("\n");
		int contador=0;
		for(String s:linhas){
			s = s.trim();
			if(s.length()>0){
				//memoria.insere(contador, t.traduzir(s));
				contador++;
			}
		}
		//usado para testar o limite de endereçamento da memória por código
		//memoria.insere(4500, new Palavra(true));
	}

	@Override
	public void valueChanged(ListSelectionEvent source) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stateChanged(ChangeEvent source) {
		// TODO Auto-generated method stub
		
	}

}
