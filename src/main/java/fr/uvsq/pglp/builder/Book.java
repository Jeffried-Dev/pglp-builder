package fr.uvsq.pglp.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe <code>Book</code> représente un livre.
 *
 * @author hal
 * @version 2024
 */
public class Book {
  @Override
  public String toString() {
    return title + ", " + author
            + ", " + year + " ("
            + chapter.size() + " chapters)";
  }
  /**
   * Un chapitre de livre.
   *
   * @param title Titre du chapitre
   * @param author Texte du nom d'auteur
   * @param year annee
   */
  public Book(String title, String author, int year) {
    this.title = title;
    this.author = author;
    this.year = year;
  }

  private final String title;
  private final String author;
  private List<Chapter> chapter;
  private final int year;
  /**
   * Un chapitre de livre.
   *
   * @param builder builder de book
   */
  public Book(Builder builder) {
    this.title = builder.title;
    this.author = builder.author;
    this.year = builder.year;
    this.chapter = builder.chapter;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public void setChapter(List<Chapter> chapter) {
    this.chapter = chapter;
  }

  public Chapter getChapter(int numero) {
    return this.chapter.get(numero-1);
  }

  public int getYear() {
    return year;
  }

  public static class Builder {
    private  String title;
    private  String author;
    private List<Chapter> chapter;
    private  int year;
    public static final int YEAR_DEFAULT = 0;
    public static final String AUTHOR_DEFAULT = null;

    /**
     * Un chapitre de livre.
     *
     * @param title Titre du chapitre
     * @param chapter Texte du chapitre
     */
    public Builder(String title, Chapter chapter) {
      this.title = title;
      List<Chapter> li = new ArrayList<>();
      li.add(chapter);
      this.chapter = li;
    }

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder author(String author) {
      this.author = author;
      return this;
    }

    public Builder year(int year) {
      this.year = year;
      return this;
    }

    public Book build() {
      return new Book(this);
    }

    public Builder addChapter(Chapter chapter2) {
      this.chapter.add(chapter2);
      return this;
    }
  }

}

