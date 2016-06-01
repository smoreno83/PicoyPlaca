import javax.swing.JOptionPane;

public class PicoyPlaca {

	public static void main(String[] args) {
		
		String consulta="";
		
	do{
	
		//Validar que al ingresar la matricula no se deje el campo en blanco ni que coloque caracteres especiales o en blanco
		String num_matricula=JOptionPane.showInputDialog("Numero de Matricula ");
		while(true){
			if(num_matricula.equals("")){
				JOptionPane.showMessageDialog(null, "Por favor no dejar espacios en blanco");
				num_matricula=JOptionPane.showInputDialog("Numero de Matricula ");	
			}else if(num_matricula.matches("([a-z]|[A-Z]|[0-9]|\\-)+")==false){
				JOptionPane.showMessageDialog(null, "Por favor introducir una matricula valida");
				num_matricula=JOptionPane.showInputDialog("Numero de Matricula ");
			}else if(num_matricula.substring(num_matricula.length()-1, num_matricula.length()).matches("([0-9]|\\s)+")==false){
				JOptionPane.showMessageDialog(null, "Por favor validar que el ultimo digito de la matricula sea un numero");
				num_matricula=JOptionPane.showInputDialog("Numero de Matricula ");
			}else{
				break;
			}
		}
	
		//Validar que al ingresar la fecha no se deje el campo en blanco y que sea una fecha valida
		String fecha=JOptionPane.showInputDialog("Fecha(dd/mm/aaaa) ");
		while(true)
		{
			if(fecha.equals("")){
				JOptionPane.showMessageDialog(null, "Por favor no dejar espacios en blanco");
				fecha=JOptionPane.showInputDialog("Fecha(dd/mm/aaaa) ");
			}else if(fecha.matches("([0-9]|\\/)+")==false){
				JOptionPane.showMessageDialog(null, "Por favor introducir una fecha valida separandola con / y usando formato de numero como se indica");
				fecha=JOptionPane.showInputDialog("Fecha(dd/mm/aaaa) ");
			}else if(fecha.length()!=10 || fecha.charAt(2)!='/' || fecha.charAt(5)!='/'){
				JOptionPane.showMessageDialog(null, "Por favor validar que separe los dias, meses y año con / y completar con cero los dias y meses menores de 10");
				fecha=JOptionPane.showInputDialog("Fecha(dd/mm/aaaa) ");	
			}else if(Integer.parseInt(fecha.substring(0, 2))>31 || Integer.parseInt(fecha.substring(3, 5))>12 || Integer.parseInt(fecha.substring(8, 10))<16){
				JOptionPane.showMessageDialog(null, "Por favor introducir los rangos correctos de los dias, meses o año");
				fecha=JOptionPane.showInputDialog("Fecha(dd/mm/aaaa) ");
			}else{
				break;
			}
		}
		int dia=Integer.parseInt(fecha.substring(0, 2));
		int mes=Integer.parseInt(fecha.substring(3, 5));
		int ano=Integer.parseInt(fecha.substring(8, 10));
		int cod_mes=0;
		
		switch(mes){
			case 1:
				cod_mes=0;
				break;
			case 2:
				cod_mes=3;
				break;
			case 3:
				cod_mes=3;
				break;
			case 4:
				cod_mes=6;
				break;
			case 5:
				cod_mes=1;
				break;
			case 6:
				cod_mes=4;
				break;
			case 7:
				cod_mes=6;
				break;
			case 8:
				cod_mes=2;
				break;
			case 9:
				cod_mes=5;
				break;
			case 10:
				cod_mes=0;
				break;
			case 11:
				cod_mes=3;
				break;
			case 12:
				cod_mes=5;
				break;

		}
	
		//Validar que al ingresar la hora no se deje el campo en blanco y que sea en un formato valido
		String hora_circulacion=JOptionPane.showInputDialog("Hora de circulacion(HH:MM) ");
		
		while(true)
		{
			if(hora_circulacion.equals("")){
				JOptionPane.showMessageDialog(null, "Por favor no dejar espacios en blanco");
				hora_circulacion=JOptionPane.showInputDialog("Hora de circulacion(HH:MM) ");
			}else if(hora_circulacion.length()!=5){
				JOptionPane.showMessageDialog(null, "Por favor introducir un formato valido (Hora militar) como se indica");
				hora_circulacion=JOptionPane.showInputDialog("Hora de circulacion(HH:MM) ");	
			}else if(hora_circulacion.matches("([0-9]|\\:)+")==false){
				JOptionPane.showMessageDialog(null, "Por favor introducir un formato valido (Hora militar) como se indica");
				hora_circulacion=JOptionPane.showInputDialog("Hora de circulacion(HH:MM) ");	
			}else{
				break;
			}
		}
		
		//Obtener ultimo digito de la matricula
		char dig_matricula=num_matricula.charAt(num_matricula.length()-1);
		
		//Formula para obtener el dia de la semana
		int e=ano/4;
		final int s=6;
		double N=(double)(dia+cod_mes+ano+e+s)/7;
		int N_entera=(int)N;
		double NN=N-N_entera;
		String cod_dia=Double.toString(NN);
		int dia_semana=Integer.parseInt(cod_dia.substring(2, 3));
		
		//Obtener hora y minuto de circulacion
		int hora=Integer.parseInt(hora_circulacion.substring(0, 2));
		int minutos=Integer.parseInt(hora_circulacion.substring(3, 5));
		int tiempo=(hora*60)+minutos;
		
		//Condicion que evalua si el vehiculo puede circular en el dia y la hora indicadas segun su matricula
		//el pico y placa se aplica de lunes a viernes de 07:00 a 09:30 y de 16:00 a 19:30
		if(dig_matricula=='1' || dig_matricula=='2')
		{
			if(dia_semana==1)
			{
				if((tiempo>=420 && tiempo <=570) || (tiempo>=960 && tiempo<=1170))
				{
					JOptionPane.showMessageDialog(null, "El vehiculo NO puede circular");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "El vehiculo SI puede circular");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "El vehiculo SI puede circular");
			}
		}
		
		if(dig_matricula=='3' || dig_matricula=='4')
		{
			if(dia_semana==2)
			{
				if((tiempo>=420 && tiempo <=570) || (tiempo>=960 && tiempo<=1170))
				{
					JOptionPane.showMessageDialog(null, "El vehiculo NO puede circular");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "El vehiculo SI puede circular");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "El vehiculo SI puede circular");
			}
		}
		
		if(dig_matricula=='5' || dig_matricula=='6')
		{
			if(dia_semana==3)
			{
				if((tiempo>=420 && tiempo <=570) || (tiempo>=960 && tiempo<=1170))
				{
					JOptionPane.showMessageDialog(null, "El vehiculo NO puede circular");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "El vehiculo SI puede circular");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "El vehiculo SI puede circular");
			}
		}
		
		if(dig_matricula=='7' || dig_matricula=='8')
		{
			if(dia_semana==4)
			{
				if((tiempo>=420 && tiempo <=570) || (tiempo>=960 && tiempo<=1170))
				{
					JOptionPane.showMessageDialog(null, "El vehiculo NO puede circular");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "El vehiculo SI puede circular");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "El vehiculo SI puede circular");
			}
		}
		
		if(dig_matricula=='9' || dig_matricula=='0')
		{
			if(dia_semana==5)
			{
				if((tiempo>=420 && tiempo <=570) || (tiempo>=960 && tiempo<=1170))
				{
					JOptionPane.showMessageDialog(null, "El vehiculo NO puede circular");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "El vehiculo SI puede circular");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "El vehiculo SI puede circular");
			}
		}
		
		consulta=JOptionPane.showInputDialog("Desea realizar una nueva consulta?....S/N");
		
	}while(consulta.equalsIgnoreCase("s"));
	
	}
}

