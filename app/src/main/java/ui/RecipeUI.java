package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

import data.RecipeFileHandler;

public class RecipeUI {
    private BufferedReader reader;
    private RecipeFileHandler fileHandler;

    public RecipeUI() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        fileHandler = new RecipeFileHandler();
    }

    public RecipeUI(BufferedReader reader, RecipeFileHandler fileHandler) {
        this.reader = reader;
        this.fileHandler = fileHandler;
    }

    public void displayMenu() {
        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        displayRecipes();
                        break;
                    case "2":
                        addNewRecipe();
                        break;
                    case "3":
                        // 設問3: 検索機能
                        break;
                    case "4":
                        System.out.println("Exit the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    /**
     * 設問1: 一覧表示機能
     * RecipeFileHandlerから読み込んだレシピデータを整形してコンソールに表示します。
     */
    private void displayRecipes() {
        RecipeFileHandler recipeFileHandler = new RecipeFileHandler(); // RecipeFileHandlerのインスタンス作成
        ArrayList<String> recipes = recipeFileHandler.readRecipes();// RecipeFileHandlerのインスタンス作成

          // 読み込んだレシピデータが空の場合の処理
        if (recipes.isEmpty()) {
            System.out.println("No recipes available.");
            return;
        }
    
        // レシピデータの表示
        System.out.println("Recipes:");
        System.out.println("-----------------------------------");
    
        // 各レシピを整形して表示
        //拡張for文
        for(String recipe : recipes){
            String[] splitted = recipe.split(","); // カンマで分割
        
            System.out.println("Recipe Name: " + splitted[0]); // レシピ名
            System.out.print("Main Ingredients: ");

                for (int i = 0; i < splitted.length; i++) {
                    System.out.print(splitted[i]);
                    if(i < splitted.length-1 ){
                        System.out.print( ",");
                    }
                }
                System.out.println();
                System.out.println("-----------------------------------");
            }
        }
    
    /**
     * 設問2: 新規登録機能
     * ユーザーからレシピ名と主な材料を入力させ、RecipeFileHandlerを使用してrecipes.txtに新しいレシピを追加します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void addNewRecipe() throws IOException {
        String recipeName = "";
        String contentToWrite = "レシピの内容";
        //レシピ名を入力
        System.out.print("Enter recipe name: ");
        String recipe = reader.readLine();
        //材料を入力
        System.out.print("Enter main ingredients (comma separated): ");
        String ingredients = reader.readLine();

        fileHandler.addRecipe(recipeName, ingredients);
        System.out.println("Recipe added successfully.");
    }

    /**
     * 設問3: 検索機能
     * ユーザーから検索クエリを入力させ、そのクエリに基づいてレシピを検索し、一致するレシピをコンソールに表示します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void searchRecipe() throws IOException {
        

        
    }

}

