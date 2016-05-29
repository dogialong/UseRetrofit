package com.example.longdg.demoretrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Longdg on 26/05/2016.
 */
public class PhimResponse {
    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<Phim> results;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;

    public PhimResponse(int page, int totalPages, int totalResults, List<Phim> results) {
        this.page = page;
        this.totalPages = totalPages;
        this.totalResults = totalResults;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Phim> getResults() {
        return results;
    }

    public void setResults(List<Phim> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
