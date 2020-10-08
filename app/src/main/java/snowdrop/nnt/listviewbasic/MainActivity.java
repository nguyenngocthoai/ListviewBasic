package snowdrop.nnt.listviewbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMH;
    ArrayList<String> course;
    Button btnAdd, btnRemove, btnUpdate;
    EditText txtName;
    int index=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btnAdd);
        btnRemove = findViewById(R.id.btnRemove);
        btnUpdate = findViewById(R.id.btnUpdate);
        txtName = findViewById(R.id.txtName);
        lvMH = findViewById(R.id.idListviewMH);
        course = new ArrayList<>();

        course.add("Android");
        course.add("IOS");
        course.add("Unity");
        course.add("Java");
        course.add("C#");
        course.add("PHP");
        course.add("C++");
        course.add("Python");
        course.add("Angular");
        course.add("Javascript");

        final ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, course);

        lvMH.setAdapter(arrayAdapter);

//        lvMH.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                /**
//                 * position: return index
//                 */
//                Toast.makeText(MainActivity.this, "" + course.get(position), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        lvMH.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, "Long click" + position, Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });

        lvMH.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtName.setText(course.get(position));
                index=position;
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                course.add(name);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index==-1){
                    Toast.makeText(MainActivity.this, "Please select a subject !", Toast.LENGTH_SHORT).show();
                }else{
                    course.remove(index);
                    arrayAdapter.notifyDataSetChanged();
                }
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                course.set(index,txtName.getText().toString());
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}