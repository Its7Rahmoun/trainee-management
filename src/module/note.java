/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package module;

/**
 *
 * @author User
 */
public class note {
    
    private int id;
    private float noteTr;
    private float notecomp;
    private float noterapport;
    private stagaire s;
    private stage st;

    public note(int id, float noteTr, float notecomp, float noterapport, stagaire s, stage st) {
        this.id = id;
        this.noteTr = noteTr;
        this.notecomp = notecomp;
        this.noterapport = noterapport;
        this.s = s;
        this.st = st;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getNoteTr() {
        return noteTr;
    }

    public void setNoteTr(float noteTr) {
        this.noteTr = noteTr;
    }

    public float getNotecomp() {
        return notecomp;
    }

    public void setNotecomp(float notecomp) {
        this.notecomp = notecomp;
    }

    public float getNoterapport() {
        return noterapport;
    }

    public void setNoterapport(float noterapport) {
        this.noterapport = noterapport;
    }

    public stagaire getS() {
        return s;
    }

    public void setS(stagaire s) {
        this.s = s;
    }

    public stage getSt() {
        return st;
    }

    public void setSt(stage st) {
        this.st = st;
    }
    
}
