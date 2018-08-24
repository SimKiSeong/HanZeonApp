package com.example.user.mother;

/**
 * Created by user on 2018-01-14.
 */

public class Notice {

    String notice;
    String work;
    String studydate;
    String seconddate;


    //이름 주소 생일 상태

    public Notice(String notice, String work, String studydate, String seconddate) {
        this.notice = notice;
        this.work = work;
        this.studydate = studydate;
        this.seconddate = seconddate;
    }



    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getStudydate() {
        return studydate;
    }

    public void setStudydate(String studydate) {
        this.studydate = studydate;
    }

    public String getSeconddate() {
        return seconddate;
    }

    public void setSeconddate(String seconddate) {
        this.seconddate = seconddate;
    }




}
