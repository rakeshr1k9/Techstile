package ogmatech.com.techstile.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import ogmatech.com.techstile.dao.NoteDao;
import ogmatech.com.techstile.entity.Note;

@Database(entities = Note.class, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase noteDatabase;

    public abstract NoteDao noteDao();

    public static synchronized NoteDatabase getNoteDatabase(Context context) {
        if (noteDatabase == null) {
            noteDatabase = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class, "note_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return noteDatabase;
    }

}
