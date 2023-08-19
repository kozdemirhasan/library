package de.kozdemir.library.dto;

import lombok.Getter;

/**
 * Created By Hasan-Murat Kücüközdemir
 * Date : 29.07.2023
 */
@Getter
public enum CategoryType {
    RESEARCH_HISTORY("Arastirma - Tarih"),
    SCIENCE("Bilim"),
    COMIC("Cizgi Roman"),
    CHILD_ANDYOUTH("Cocuk ve Genclik"),
    LESSON_TEST_BOOKS("Ders / Sinav Kitaplari"),
    RELIGION("Din Tasavvuf"),
    LITERATURE("Edebiyat"),
    EDUCATION_REFERANCE("Egitim Basvuru"),
    PHILOSOPHY("Felsefe"),
    FOREIGN_LANGUAGES("Foreign Languages"),
    HOBBY("Hobi"),
    MYTH_LEGEND("Mitoloji Efsane"),
    HUMOR("Mizah"),
    PRESTIGE_BOOKS("Prestij Kitaplari"),
    ART_DESIGN("Sanat Tasarim"),
    AUDIO_BOOKS("Sesli Kitaplar"),
    OTHER("Diger");

   private final String value;

    CategoryType(String value) {
        this.value = value;
    }
}
