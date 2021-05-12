package com.example.cde_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.example.cde_app.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseFirestore fireStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        fireStore = FirebaseFirestore.getInstance();

        getSupportActionBar().hide();

        final ArrayList<CategoryModel> categoryModels = new ArrayList<>();
        final CategoryAdapter adapter = new CategoryAdapter(this, categoryModels);

        fireStore.collection("categories").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                categoryModels.clear();
                for(DocumentSnapshot snapshot : value.getDocuments()){
                    CategoryModel model = snapshot.toObject(CategoryModel.class);
                    model.setCategoryId(snapshot.getId());
                    categoryModels.add(model);
                }
                adapter.notifyDataSetChanged();
            }
        });

        binding.categoryList.setLayoutManager(new GridLayoutManager(this,2));
        binding.categoryList.setAdapter(adapter);

    }
}