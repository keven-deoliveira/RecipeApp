package com.bueng.healthyhelpers;
import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

//This class is used to connect to firebase and access the database of recipes*/

public class FirebaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceRecipes;
    public static List<Recipe> recipes = new ArrayList<>(4); //array list of recipes to be displayed


    public interface DataStatus {
        void DataIsLoaded(List<Recipe> recipes, List<String> keys);
    }

    //Constructor, takes restriction as input to determine which library of recipes to search from
    public FirebaseDatabaseHelper(String restriction) {
        mDatabase = FirebaseDatabase.getInstance();
        if (restriction == "vegan") {
            mReferenceRecipes = mDatabase.getReference("vegan");
        }
        else if (restriction == "vegetarian") {
            mReferenceRecipes = mDatabase.getReference("vegetarian");
        }
        else {
            mReferenceRecipes = mDatabase.getReference("other");
        }
    }

    //Reads recipes from chosen library from above, checks to see if ingredients match
    public void readRecipes(final DataStatus dataStatus, final String ingredient1, final String ingredient2,
                            final String ingredient3, final String ingredient4, final String ingredient5,
                            final String ingredient6) {

        mReferenceRecipes.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                recipes.clear(); //clears old data
                List<String> keys = new ArrayList<>();
                String searchIngredients = "";
                int array_size = 0;
                int matchingIngredients = 0;

                //1 matching ingredient
                for (DataSnapshot keyNode1 : dataSnapshot.getChildren()) { //goes through all recipes in specific library
                    array_size = recipes.size();
                    if (array_size >= 4) {
                        break;
                    }
                    matchingIngredients = 0;
                    keyNode1.getKey();
                    Recipe recipe1 = keyNode1.getValue(Recipe.class);
                    assert recipe1 != null;
                    searchIngredients = recipe1.ingredients;

                    if(searchIngredients.contains(ingredient1))
                        matchingIngredients++;
                    if(searchIngredients.contains(ingredient2))
                        matchingIngredients++;
                    if(searchIngredients.contains(ingredient3))
                        matchingIngredients++;
                    if(searchIngredients.contains(ingredient4))
                        matchingIngredients++;
                    if(searchIngredients.contains(ingredient5))
                        matchingIngredients++;
                    if(searchIngredients.contains(ingredient6))
                        matchingIngredients++;

                    if(matchingIngredients==1){
                        recipes.add(recipe1);
                        keys.add(keyNode1.getKey());
                    }

                    //2 matching ingredients
                    for (DataSnapshot keyNode2 : dataSnapshot.getChildren()) { //goes through all recipes in specific library
                        array_size = recipes.size();
                        if (array_size >= 4) {
                            break;
                        }
                        matchingIngredients = 0;
                        keyNode2.getKey();
                        Recipe recipe2 = keyNode2.getValue(Recipe.class);
                        assert recipe2 != null;
                        searchIngredients = recipe2.ingredients;

                        if(searchIngredients.contains(ingredient1))
                            matchingIngredients++;
                        if(searchIngredients.contains(ingredient2))
                            matchingIngredients++;
                        if(searchIngredients.contains(ingredient3))
                            matchingIngredients++;
                        if(searchIngredients.contains(ingredient4))
                            matchingIngredients++;
                        if(searchIngredients.contains(ingredient5))
                            matchingIngredients++;
                        if(searchIngredients.contains(ingredient6))
                            matchingIngredients++;

                        if(matchingIngredients==2){
                            recipes.add(recipe2);
                            keys.add(keyNode2.getKey());
                        }

                        //3 matching ingredients
                        for (DataSnapshot keyNode3 : dataSnapshot.getChildren()) { //goes through all recipes in specific library
                            array_size = recipes.size();
                            if (array_size >= 4) {
                                break;
                            }
                            matchingIngredients = 0;
                            keyNode3.getKey();
                            Recipe recipe3 = keyNode3.getValue(Recipe.class);
                            assert recipe3 != null;
                            searchIngredients = recipe3.ingredients;

                            if(searchIngredients.contains(ingredient1))
                                matchingIngredients++;
                            if(searchIngredients.contains(ingredient2))
                                matchingIngredients++;
                            if(searchIngredients.contains(ingredient3))
                                matchingIngredients++;
                            if(searchIngredients.contains(ingredient4))
                                matchingIngredients++;
                            if(searchIngredients.contains(ingredient5))
                                matchingIngredients++;
                            if(searchIngredients.contains(ingredient6))
                                matchingIngredients++;

                            if(matchingIngredients==3){
                                recipes.add(recipe3);
                                keys.add(keyNode3.getKey());
                            }

                            //4 matching ingredients
                            for (DataSnapshot keyNode4 : dataSnapshot.getChildren()) { //goes through all recipes in specific library
                                array_size = recipes.size();
                                if (array_size >= 4) {
                                    break;
                                }
                                matchingIngredients = 0;
                                keyNode4.getKey();
                                Recipe recipe4 = keyNode4.getValue(Recipe.class);
                                assert recipe4 != null;
                                searchIngredients = recipe4.ingredients;

                                if(searchIngredients.contains(ingredient1))
                                    matchingIngredients++;
                                if(searchIngredients.contains(ingredient2))
                                    matchingIngredients++;
                                if(searchIngredients.contains(ingredient3))
                                    matchingIngredients++;
                                if(searchIngredients.contains(ingredient4))
                                    matchingIngredients++;
                                if(searchIngredients.contains(ingredient5))
                                    matchingIngredients++;
                                if(searchIngredients.contains(ingredient6))
                                    matchingIngredients++;

                                if(matchingIngredients==4){
                                    recipes.add(recipe4);
                                    keys.add(keyNode4.getKey());
                                }

                                //5 matching ingredients
                                for (DataSnapshot keyNode5 : dataSnapshot.getChildren()) { //goes through all recipes in specific library
                                    array_size = recipes.size();
                                    if (array_size >= 4) {
                                        break;
                                    }
                                    matchingIngredients = 0;
                                    keyNode5.getKey();
                                    Recipe recipe5 = keyNode5.getValue(Recipe.class);
                                    assert recipe5 != null;
                                    searchIngredients = recipe5.ingredients;

                                    if(searchIngredients.contains(ingredient1))
                                        matchingIngredients++;
                                    if(searchIngredients.contains(ingredient2))
                                        matchingIngredients++;
                                    if(searchIngredients.contains(ingredient3))
                                        matchingIngredients++;
                                    if(searchIngredients.contains(ingredient4))
                                        matchingIngredients++;
                                    if(searchIngredients.contains(ingredient5))
                                        matchingIngredients++;
                                    if(searchIngredients.contains(ingredient6))
                                        matchingIngredients++;

                                    if(matchingIngredients==5){
                                        recipes.add(recipe5);
                                        keys.add(keyNode5.getKey());
                                    }


                                    //6 matching ingredients
                                    for (DataSnapshot keyNode6 : dataSnapshot.getChildren()) { //goes through all recipes in specific library
                                        array_size = recipes.size();
                                        if (array_size >= 4) {
                                            break;
                                        }
                                        matchingIngredients = 0;
                                        keyNode6.getKey();
                                        Recipe recipe6 = keyNode6.getValue(Recipe.class);
                                        assert recipe6 != null;
                                        searchIngredients = recipe6.ingredients;

                                        if(searchIngredients.contains(ingredient1))
                                            matchingIngredients++;
                                        if(searchIngredients.contains(ingredient2))
                                            matchingIngredients++;
                                        if(searchIngredients.contains(ingredient3))
                                            matchingIngredients++;
                                        if(searchIngredients.contains(ingredient4))
                                            matchingIngredients++;
                                        if(searchIngredients.contains(ingredient5))
                                            matchingIngredients++;
                                        if(searchIngredients.contains(ingredient6))
                                            matchingIngredients++;

                                        if(matchingIngredients==6){
                                            recipes.add(recipe6);
                                            keys.add(keyNode6.getKey());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                dataStatus.DataIsLoaded(recipes, keys);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
