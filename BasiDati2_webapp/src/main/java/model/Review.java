package model;

public class Review {
    private String reviewDate;
    private String reviewerName;
    private  String comment;

    public Review(String reviewDate, String reviewerName, String comment) {
        this.reviewDate = reviewDate;
        this.reviewerName = reviewerName;
        this.comment = comment;
    }

    public Review() {
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
