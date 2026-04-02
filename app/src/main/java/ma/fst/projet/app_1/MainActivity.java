package ma.fst.projet.app_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ma.fst.projet.app_1.classes.Etudiant;
import ma.fst.projet.app_1.service.EtudiantService;

public class MainActivity extends AppCompatActivity {

    private EditText nom, prenom, id;
    private Button add, rechercher, supprimer;
    private TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EtudiantService es = new EtudiantService(this);

        // bind views
        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        id = findViewById(R.id.input_id);

        add = findViewById(R.id.bn);
        rechercher = findViewById(R.id.load);
        supprimer = findViewById(R.id.delete);

        res = findViewById(R.id.res);

        add.setOnClickListener(v -> {
            String n = nom.getText().toString();
            String p = prenom.getText().toString();

            if (n.isEmpty() || p.isEmpty()) {
                Toast.makeText(this, "Remplir tous les champs", Toast.LENGTH_SHORT).show();
                return;
            }

            es.create(new Etudiant(n, p));

            nom.setText("");
            prenom.setText("");

            Toast.makeText(this, "Étudiant ajouté", Toast.LENGTH_SHORT).show();
        });

        rechercher.setOnClickListener(v -> {
            String txt = id.getText().toString().trim();

            if (txt.isEmpty()) {
                Toast.makeText(this, "Saisir un id", Toast.LENGTH_SHORT).show();
                return;
            }

            Etudiant e = es.findById(Integer.parseInt(txt));

            if (e == null) {
                res.setText("");
                Toast.makeText(this, "Introuvable", Toast.LENGTH_SHORT).show();
            } else {
                res.setText(e.getId() + " | " + e.getNom() + " " + e.getPrenom());
            }
        });

        supprimer.setOnClickListener(v -> {
            String txt = id.getText().toString().trim();

            if (txt.isEmpty()) {
                Toast.makeText(this, "Saisir un id", Toast.LENGTH_SHORT).show();
                return;
            }

            Etudiant e = es.findById(Integer.parseInt(txt));

            if (e == null) {
                Toast.makeText(this, "Étudiant introuvable", Toast.LENGTH_SHORT).show();
                return;
            }

            es.delete(e.getId());

            res.setText("");
            Toast.makeText(this, "Supprimé avec succès", Toast.LENGTH_SHORT).show();
        });
    }
}