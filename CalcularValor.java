
public class CalcularValor {
	private Acesso acesso;
	private int quantidadeHoras;
	private int quantidadeMinutos;
	CalcularValor(Acesso acesso, int quantidadeHoras){
		this.acesso = acesso;
		this.quantidadeHoras = quantidadeHoras;
	}
	
	float computar(){
		int horaSaida = acesso.horaSaida;
		int horaEntrada = acesso.horaEntrada;
		int minutosSaida = acesso.minutosSaida;
		int minutosEntrada = acesso.minutosEntrada;
		
		calcularTempoPassado(horaSaida, horaEntrada, minutosSaida, minutosEntrada);
		
		float valorHoras = quantidadeHoras * Acesso.VALOR_HORA;
		float valorFracaoDeMinutos = (float) Math.ceil(quantidadeMinutos / 15.0) * Acesso.VALOR_FRACAO;
		
		if (quantidadeHoras >= 9)
			return Acesso.VALOR_DIARIA;
		else 
			return valorHoras + valorFracaoDeMinutos;
	}

	private void calcularTempoPassado(int horaSaida, int horaEntrada, int minutosSaida, int minutosEntrada) {
		if (horaSaida == horaEntrada)
			quantidadeMinutos = minutosSaida - minutosEntrada;
		else if (horaSaida > horaEntrada && minutosEntrada == minutosSaida){
			quantidadeMinutos = 0;
			quantidadeHoras = horaSaida - horaEntrada;
		}
		else if (horaSaida > horaEntrada && minutosEntrada > minutosSaida) 
			quantidadeMinutos = minutosSaida - minutosEntrada;
		else if (horaSaida > horaEntrada && minutosSaida < minutosEntrada){
			quantidadeMinutos = minutosSaida + (60 - minutosEntrada);
			quantidadeHoras = horaSaida - horaEntrada - 1;
		}
		else {
			quantidadeHoras = 0;
			quantidadeMinutos = 0;
		}
	}
}
