package com.vachanamrut.questions.model;

import java.io.Serializable;
import java.util.Objects;

public class QuestionId implements Serializable {

    protected String location;
    protected int section;
    protected int questionNumber;

    public QuestionId(){}

    public QuestionId(String location, int section, int questionNumber) {
        this.location = location;
        this.section = section;
        this.questionNumber = questionNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionId)) return false;
        QuestionId that = (QuestionId) o;
        return section == that.section &&
                questionNumber == that.questionNumber &&
                location.equals(that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, section, questionNumber);
    }
}
