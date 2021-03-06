package model;

/**
 * Created by Richard Killam, 3412522 on 15/04/15.
 */
public class DocumentItem extends DocumentComponent {
    private Character character;

    public DocumentItem(Character character) {
        this.character = character;
    }

    @Override
    public String toString() {
        if(this.character == '\0') {
            return "";
        }
        else {
            return this.character.toString();
        }
    }
}
