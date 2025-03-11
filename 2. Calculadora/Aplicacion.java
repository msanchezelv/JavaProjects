import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aplicacion {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicacion");
        frame.setContentPane(new Aplicacion().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JLabel lblDisplay;
    private JButton btnReset;
    private JPanel Cabecera;
    private JPanel Botonera;
    private JButton a7Button;
    private JButton a4Button;
    private JButton a1Button;
    private JButton btnPunto;
    private JButton a8Button;
    private JButton a5Button;
    private JButton a2Button;
    private JButton a0Button;
    private JButton a9Button;
    private JButton a6Button;
    private JButton a3Button;
    private JButton btnIgual;
    private JButton btnDivision;
    private JButton btnProducto;
    private JButton btnResta;
    private JButton btnSuma;
    private JPanel root;

    // Calculadora
    public Aplicacion() {

        // Listeners y acciones para los números
        a7Button.addActionListener(listenerNumeros);
        a4Button.addActionListener(listenerNumeros);
        a1Button.addActionListener(listenerNumeros);
        a8Button.addActionListener(listenerNumeros);
        a5Button.addActionListener(listenerNumeros);
        a2Button.addActionListener(listenerNumeros);
        a0Button.addActionListener(listenerNumeros);
        a9Button.addActionListener(listenerNumeros);
        a6Button.addActionListener(listenerNumeros);
        a3Button.addActionListener(listenerNumeros);
        btnPunto.addActionListener(listenerNumeros);

        // Acción que se lleva a cabo al resetear la calculadora
        btnReset.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                lblDisplay.setText(" ");
            }
        });

        // Listeners y acciones para las operaciones
        btnDivision.addActionListener(listenerOperadores);
        btnProducto.addActionListener(listenerOperadores);
        btnResta.addActionListener(listenerOperadores);
        btnSuma.addActionListener(listenerOperadores);
        btnIgual.addActionListener(listenerOperadores);

    }

    // Acción para cuando se hace click en los números
    ActionListener listenerNumeros = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String texto = lblDisplay.getText() + ((JButton) e.getSource()).getText();
            lblDisplay.setText(texto);
        }
    };

    // Acción para cuando se hace click en los operadores
    ActionListener listenerOperadores = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Resuelve la operación existente si la hay
            String resultado = calcular(lblDisplay.getText());
            lblDisplay.setText(resultado);

            // Añade el operador siguiente si no es "="
            if (e.getSource() != btnIgual) {
                String texto = lblDisplay.getText() + ((JButton) e.getSource()).getText();
                lblDisplay.setText(texto);
            }
        }
    };

    // Función para calcular las operaciones
    public String calcular(String operacion){
        String resultado;

        // Partes de la cadena de la expresión
        String[] ops = operacion.split("[\\+\\-X\\/]");

        if (ops.length == 1 ){
            // Si la matriz resultante solo tiene un elemento, será el resultado el mismo valor
            resultado = ops[0];
        }else{
            // Si la matriz tiene más de un elemento significa que tendrá que resolver la operación
            float v1 = Float.parseFloat(ops[0]);    // Convierte el valor de la cadena 1 en float
            float v2 = Float.parseFloat(ops[1]);    // Convierte el valor de la cadena 2 en float
            float r;                                // Resultado

            if ( operacion.contains("+"))
                r = v1 + v2;                        // Si la cadena incluye +, sumamos
            else if ( operacion.contains("-"))
                r = v1 - v2;                        // Si la cadena incluye -, restamos
            else if( operacion.contains("*"))
                r = v1 * v2;                        // Si la cadena incluye *, multiplicamos
            else
                r = v1 / v2;                       // Por defecto se divide

            // Convertimos el resultado a String
            resultado = String.valueOf(r);

        }
        return resultado;
    }

}
