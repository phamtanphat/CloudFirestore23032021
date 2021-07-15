package com.example.cloudfirestore23032021;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Iterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1 Gửi dạng map String
        // Khoa hoc
//            - android
//                    - ten : Lap trinh android
//            - ios
//                    - ten : Lap trinh ios
//        Map<String,String> mapCourse = new HashMap<>();
//        mapCourse.put("ten", "Lập trình ios");
//
//        db.collection("khoahoc")
//                .document("ios")
//                .set(mapCourse)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()){
//                            Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
//                        }else{
//                            Toast.makeText(MainActivity.this, "Thất bại", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
        // 2 Gui dang mang
//        Map<String , List<String>> mapNames = new HashMap<>();
//        mapNames.put("arrays", new ArrayList<>(Arrays.asList("Tèo" , "Tí" , "Tủn" , "Hoa")));
//
//        db.collection("mangten")
//                .document("array")
//                .set(mapNames)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()){
//                            Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
//                        }else{
//                            Toast.makeText(MainActivity.this, "Thất bại", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });

        //3 : Gui dang object
//        Animal animal = new Animal("Dog",5);
//
//        db.collection("animal")
//                .document("athome")
//                .set(animal)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()){
//                            Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
//                        }else{
//                            Toast.makeText(MainActivity.this, "Thất bại", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });

        // 4 : Gui dang random id
//        Product product = new Product("product2",20000);
//        db.collection("product")
//                .add(product);

        /* ================================================================ */

        // 1  Doc du lieu dang string
//        DocumentReference khoahocRef =  db.collection("khoahoc").document("android");
//        khoahocRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
//                String chuoi = "";
//                if (value != null && value.exists()) {
//                    chuoi = (String) value.getData().get("ten");
//                    Toast.makeText(MainActivity.this, chuoi, Toast.LENGTH_SHORT).show();
//                } else {
//                    System.out.print("Current data: null");
//                }
//
//            }
//        });
        //2 : Đoc dữ liệu dang mảng
//        DocumentReference arrRef = db.collection("mangten").document("array");
//        arrRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
//                if (value != null && value.exists()){
//                    Map<String,Object> mapData = value.getData();
//                    Iterator iterator = mapData.keySet().iterator();
//                    while (iterator.hasNext()){
//                        Log.d("BBB",mapData.get(iterator.next()).toString());
//                    }
//                }
//            }
//        });

        // 3 Dang Object
//        DocumentReference objectRef  = db.collection("animal").document("athome");
//        objectRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
//                if (value != null && value.exists()){
//                    Animal animal = value.toObject(Animal.class);
//                    Log.d("BBB",animal.toString());
//                }
//            }
//        });
        // 4  : Đọc dữ liệu dạng list document

        db.collection("product").whereEqualTo("name","product2").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (DocumentSnapshot snapshot: task.getResult().getDocuments()) {
                        Map<String,Object> objectMap = snapshot.getData();
                        Iterator iterator = objectMap.keySet().iterator();
                        String name = "";
                        String price = "";
                        while (iterator.hasNext()){
                            String key = iterator.next().toString();
                            if (key.equals("price")){
                                price = objectMap.get(key).toString();
                            }else{
                                name = objectMap.get(key).toString();
                            }
                        }
                        Log.d("BBB","Document SnapShoot " + snapshot.getId());
                        Log.d("BBB", "Name " + name);
                        Log.d("BBB", "Price " + price);
                    }
                }
            }
        });

    }
}