package data;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class RecipeFileHandler {
    private String filePath;

    public RecipeFileHandler() {
        filePath = "app/src/main/resources/recipes.txt";
    }

    public RecipeFileHandler(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 設問1: 一覧表示機能
     * recipes.txtからレシピデータを読み込み、それをリスト形式で返します。 <br>
     * IOExceptionが発生したときは<i>Error reading file: 例外のメッセージ</i>とコンソールに表示します。
     *
     * @return レシピデータ
     */
    public ArrayList<String> readRecipes() {
        ArrayList<String> recipes = new ArrayList<>();
        //ファイルの読み込み
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
                String line;//1行単位
                while ((line = reader.readLine()) != null) {//1行ずつ
                    recipes.add(line);
                }
            //IOExceptionが発生したとき
            }catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
        }
        //読み込んだレシピを返す
        return recipes;
    }


    /**
     * 設問2: 新規登録機能
     * 新しいレシピをrecipes.txtに追加します。<br>
     * レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
     *
     * @param recipeName レシピ名
     * @param ingredients 材料名
     */
     //
    public void addRecipe(String recipeName, String ingredients) {
        // レシピ名と材料をカンマ区切りで1行にまとめる
        String contentToWrite = recipeName + "," + ingredients;
        //ファイルの書き込み
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(contentToWrite);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
