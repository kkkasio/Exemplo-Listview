package eduardo.kasio.listview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ListView listaItens;
    private String[] itens = {"Cabo Frio", "Búzios", "Arraial do Cabo", "Rio de Janeiro", "São Paulo",
            "Florianópolis", "Santa Catarina", "Niterói", "Bangu", "Angra dos Reis", "Tiradentes",
            "Recife", "Porto Seguro"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();
        listaItens.setAdapter(getAdapter());

        listaItens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int codigoPosicao = i;
                String texto = (String) listaItens.getItemAtPosition(codigoPosicao);
                mensagem(texto);
            }
        });
    }

    private void mensagem(String texto) {
        Toast.makeText(getApplicationContext(),texto,Toast.LENGTH_SHORT).show();
    }

    private void inicializarComponentes() {
        listaItens = (ListView) findViewById(R.id.listViewId);
    }

    public ListAdapter getAdapter() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens);
        return adapter;
    }
}
