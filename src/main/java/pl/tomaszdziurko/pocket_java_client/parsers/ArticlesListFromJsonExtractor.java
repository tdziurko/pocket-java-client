package pl.tomaszdziurko.pocket_java_client.parsers;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.listing.Article;

import java.util.List;

public class ArticlesListFromJsonExtractor {

    private Gson gson;

    public ArticlesListFromJsonExtractor(Gson gson) {
        this.gson = gson;
    }

    public List<Article> extractArticlesData(String jsonString) {

        List<Integer> articlesStartIndexes = getArticlesStartIndexes(jsonString);
        List<String> articleStrings = extractArticleStrings(jsonString, articlesStartIndexes);

        return convertToObjects(articleStrings);
    }

    List<Integer> getArticlesStartIndexes(String jsonString) {
        List<Integer> indexes = Lists.newArrayList();

        int currentIndex = -1;
        while (true) {
            currentIndex = jsonString.indexOf("{\"item_id\":", currentIndex + 1);

            if (currentIndex >= 0) {
                indexes.add(currentIndex);
            } else {
                break;
            }
        }

        return indexes;
    }

    List<String> extractArticleStrings(String jsonString, List<Integer> articlesStartIndexes) {
        List<String> articleStrings = Lists.newArrayList();

        for (int i = 0; i < articlesStartIndexes.size(); i++) {
            if (i < articlesStartIndexes.size() - 1) {
                String articleWithSomeJunkAtEnd = jsonString.substring(articlesStartIndexes.get(i), articlesStartIndexes.get(i + 1));
                String article = articleWithSomeJunkAtEnd.substring(0, articleWithSomeJunkAtEnd.lastIndexOf("}") + 1);
                articleStrings.add(article);
            } else {
                String article = jsonString.substring(articlesStartIndexes.get(i), jsonString.lastIndexOf("}}") + 1);
                articleStrings.add(article);
            }
        }

        return articleStrings;
    }

    List<Article> convertToObjects(List<String> articleStrings) {
        List<Article> articles = Lists.newArrayList();

        for (String articleString : articleStrings) {
            System.out.println("articleString = \n" + articleString);
            articles.add(gson.fromJson(articleString, Article.class));
        }

        return articles;
    }
}
