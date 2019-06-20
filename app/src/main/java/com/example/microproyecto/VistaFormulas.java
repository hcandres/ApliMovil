package com.example.microproyecto;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

public class VistaFormulas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_formulas);
        mostrarformula();
    }

    private void mostrarformula() {
        TextView infoFormula = (TextView) findViewById(R.id.txInfoFormula);
        TextView nombreFormula = (TextView) findViewById(R.id.txNombreFormula);

        Intent i = getIntent();
        Bundle b = i.getExtras();

        String nomFormula = b.getString("formula");

        switch (nomFormula){

            case "Derivada":
                nombreFormula.setText(nomFormula);
                infoFormula.setText("En matemáticas, la derivada de una función, es la razón de cambio instantánea con la que cambia el valor de dicha función matemática, según cambie el valor de su variable independiente. La derivada de una función es un concepto local, es decir, se calcula como el límite de la rapidez de cambio media de la función en cierto intervalo, cuando el intervalo considerado para la variable independiente se torna cada vez más pequeño. Por ello se habla del valor de la derivada de una función en un punto dado.\n" +
                        "\n" +
                        "Un ejemplo habitual aparece al estudiar el movimiento: si una función representa la posición de un objeto con respecto al tiempo, su derivada es la velocidad de dicho objeto. Un avión que realice un vuelo transatlántico de 4500 km entre las 12:00 y las 18:00, viaja a una velocidad media de 750 km/h. Sin embargo, puede estar viajando a velocidades mayores o menores en distintos tramos de la ruta. En particular, si entre las 15:00 y las 15:30 recorre 400 km, su velocidad media en ese tramo es de 800 km/h. Para conocer su velocidad instantánea a las 15:20, por ejemplo, es necesario calcular la velocidad media en intervalos de tiempo cada vez menores alrededor de esta hora: entre las 15:15 y las 15:25, entre las 15:19 y las 15:21.\n" +
                        "\n" +
                        "Entonces el valor de la derivada de una función en un punto puede interpretarse geométricamente, ya que se corresponde con la pendiente de la recta tangente a la gráfica de la función en dicho punto. La recta tangente es, a su vez, la gráfica de la mejor aproximación lineal de la función alrededor de dicho punto. La noción de derivada puede generalizarse para el caso de funciones de más de una variable con la derivada parcial y el diferencial.");

                break;

            case "Integral":
                nombreFormula.setText(nomFormula);
                infoFormula.setText("La integración es un concepto fundamental del cálculo y del análisis matemático. Básicamente, una integral es una generalización de la suma de infinitos sumandos, infinitamente pequeños.\n" +
                        "\n" +
                        "El cálculo integral, encuadrado en el cálculo infinitesimal, es una rama de las matemáticas en el proceso de integración o antiderivación. Es muy común en la ingeniería y en la ciencia; se utiliza principalmente para el cálculo de áreas y volúmenes de regiones y sólidos de revolución.\n" +
                        "\n" +
                        "Fue usado por primera vez por científicos como Arquímedes, René Descartes, Isaac Newton, Gottfried Leibniz e Isaac Barrow. Los trabajos de este último y los aportes de Newton generaron el teorema fundamental del cálculo integral, que propone que la derivación y la integración son procesos inversos.");
                break;

            case "Fuerza":
                nombreFormula.setText(nomFormula);
                infoFormula.setText("En física, la fuerza es una magnitud vectorial que mide la razón de cambio de momento lineal entre dos partículas o sistemas de partículas. Según una definición clásica, fuerza es todo agente capaz de modificar la cantidad de movimiento o la forma de los materiales. No debe confundirse con los conceptos de esfuerzo o de energía.\n" +
                        "\n" +
                        "En el Sistema Internacional de Unidades, la unidad de medida de la fuerza es el newton que se representa con el símbolo N, nombrada así en reconocimiento a Isaac Newton por su aportación a la física, especialmente a la mecánica clásica. El newton es una unidad derivada del Sistema Internacional de Unidades que se define como la fuerza necesaria para proporcionar una aceleración de 1 m/s² a un objeto de 1 kg de masa.");
                break;

            case "Trabajo":
                nombreFormula.setText(nomFormula);
                infoFormula.setText("En mecánica clásica, se dice que una fuerza realiza trabajo cuando hay un desplazamiento de su punto de aplicación. El trabajo de la fuerza sobre ese cuerpo será equivalente a la energía necesaria para desplazarlo1\u200B. Por consiguiente, se dice que una cierta masa tiene energía cuando esa masa tiene la capacidad de producir un trabajo; además, con esta afirmación se deduce que no hay trabajo sin energía. Por ello, se dice que el carbón, la gasolina, la electricidad, los átomos son fuentes de energía, pues pueden producir algún trabajo o convertirse en otro tipo de energía; para entender esto se tiene en cuenta el principio universal de la energía según el cual la energía no se crea ni se destruye, solamente se transforma.2\u200B El trabajo es una magnitud física escalar que se representa con la letra {\\displaystyle \\ W} \\ W (del inglés Work) y se expresa en unidades de energía, esto es en julios o joules (J) en el Sistema Internacional de Unidades.\n" +
                        "\n" +
                        "Ya que por definición el trabajo es un tránsito de energía,3\u200B nunca se refiere a él como incremento de trabajo, ni se simboliza como ΔW.");
                nomFormula = "Trabajo_(física)";
                break;

            case "Area":
                nombreFormula.setText(nomFormula);
                infoFormula.setText("El área es un concepto métrico que permite asignar una medida a la extensión de una superficie, expresada en matemáticas como unidades de medida denominadas unidades de superficie.1\u200B El área es un concepto métrico que requiere la especificación de una medida de longitud.\n" +
                        "\n" +
                        "El área es una magnitud métrica de tipo escalar\u200B definida como la extensión en dos dimensiones de una recta al plano del espacio.\n" +
                        "\n" +
                        "Para superficies planas, el concepto es más intuitivo. Cualquier superficie plana de lados rectos —es decir, cualquier polígono— puede triangularse, y se puede calcular su área como suma de las áreas de los triángulos en que se descompone.2\u200B Ocasionalmente se usa el término \"área\" como sinónimo de superficie,3\u200B cuando no existe confusión entre el concepto geométrico en sí mismo (superficie) y la magnitud métrica asociada al concepto geométrico (área).\n" +
                        "\n" +
                        "Sin embargo, para calcular el área de superficies curvas se requiere introducir métodos de geometría diferencial.\n" +
                        "\n" +
                        "Para poder definir el área de una superficie en general —que es un concepto métrico—, se tiene que haber definido un tensor métrico sobre la superficie en cuestión: cuando la superficie está dentro de un espacio euclídeo, la superficie hereda una estructura métrica natural inducida por la métrica euclidiana.");
                break;

            case "Volumen":
                nombreFormula.setText(nomFormula);
                infoFormula.setText("El volumen1\u200B es una magnitud métrica de tipo escalar2\u200B definida como la extensión en tres dimensiones de una región del espacio. Es una magnitud derivada de la longitud, ya que se halla multiplicando la longitud, el ancho y la altura. Matemáticamente el volumen es definible no sólo en cualquier espacio euclídeo, sino también en otro tipo de espacios métricos que incluyen por ejemplo a las variedades de Riemann.\n" +
                        "\n" +
                        "Desde un punto de vista físico, los cuerpos materiales ocupan un volumen por el hecho de ser extensos, fenómeno que se debe al principio de exclusión de Pauli. La noción de volumen es más complicada que la de superficie y en su uso formal puede dar lugar a la llamada paradoja de Banach-Tarski.\n" +
                        "\n" +
                        "La unidad de medida de volumen en el Sistema Internacional de Unidades es el metro cúbico. Para medir la capacidad se utiliza el litro. Por razones históricas, existen unidades separadas para ambas, sin embargo están relacionadas por la equivalencia entre el litro y el decímetro cúbico:\n" +
                        "\n" +
                        "1 dm3 = 1 litro = 0,001 m3 = 1000 cm3.");
                break;
        }masInfo(nomFormula);
    }

    Button btMasInfo;
    private void masInfo(final String nomFormula){
        btMasInfo = (Button) findViewById(R.id.btMasInfo);
        btMasInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buscar = new Intent(Intent.ACTION_VIEW,Uri.parse(("https://es.wikipedia.org/wiki/")+nomFormula));
                startActivity(buscar);
            }
        });
    }


}
