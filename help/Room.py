from Base import *


def dao_temp(r: str, m: str):
    return '''package com.example.''' + m + '''.room.dao
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.''' + m + '''.room.entity.''' + r + '''Entity

@Dao
interface ''' + r + '''Dao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun add''' + r + '''(data: ''' + r + '''Entity)
}'''


def repository_temp(r: str, m: str):
    return '''package com.example.''' + m + '''.room.repository
import com.example.''' + m + '''.room.dao.''' + r + '''Dao
import com.example.''' + m + '''.room.entity.''' + r + '''Entity

class ''' + r + '''Repository ( val dao: ''' + r + '''Dao) {
  
}'''


def entity_temp(i, r, m):
    return '''package com.example.''' + m + '''.room.entity
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
@Entity(tableName = "''' + i + '''_table")
@Parcelize
data class ''' + r + '''Entity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
) : Parcelable {

}'''


ybag = []
bbag = []

rbag= []
gbag = []
vbag = []
def dao_entity_repository(i: str, m: str):
    i = i.lower()
    i = i.lower()
    r = i.capitalize()
    ybag.append(f'''import com.example.{m}.room.dao.{r}Dao
import com.example.{m}.room.entity.{r}Entity''')
    bbag.append(f'abstract fun {i}Dao(): {r}Dao')
    rbag.append(f'import com.example.{m}.room.repository.{r}Repository')
    gbag.append(f'private val {i}rository: {r}Repository')
    vbag.append(f'''val {i}Dao = SivaDatabase.getDatabase(application).{i}Dao()
{i}rository = {r}Repository({i}Dao)''')


    with (e_p / f'{r}Entity.kt').open('w') as f:
        f.write(entity_temp(i, r, m))
        f.close()
    with (e_r / f'{r}Repository.kt').open('w') as f:
        f.write(repository_temp(r, m))
        f.close()
    with (e_d / f'{r}Dao.kt').open('w') as f:
        f.write(dao_temp(r, m))
        f.close()


def db_temp(r, m):
    return '''package com.example.''' + m + '''.room.db
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [],
    version = 1,
    exportSchema = true
)
abstract class ''' + r + '''Database: RoomDatabase()  {
    companion object {
        @Volatile
        var INSTANCE: ''' + r + '''Database? = null

        fun getDatabase(context: Context): ''' + r + '''Database {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.inMemoryDatabaseBuilder(
                    context,
                    ''' + r + '''Database::class.java,
                ).allowMainThreadQueries().build()
                INSTANCE = instance

                return instance
            }

        }
    }
}
'''


e_d = None


def db(i: str, m: str, c: bool = True):
    i = i.lower()
    r = i.capitalize()
    with (e_db / f'{r}Database.kt').open('w') as f:
        f.write(db_temp(r, m))
        f.close()

def viewmodel(r:str,m:str):
    return '''package com.example.''' + m + '''.room.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class ''' + r + '''ViewModel (application: Application) : AndroidViewModel(application) {

    init {

    }

}'''
def vm(i:str,m:str):
    i = i.lower()
    n = i.capitalize()
    with (e_vm / f'{n}ViewModel.kt').open('w') as f:
        f.write(viewmodel(n,m))
        f.close()

if __name__ == '__main__':
    p = pathlib.Path(r'E:\win\share\Cat\app\src\main\java\com\example\cat\room')
    e_p = p / 'entity'
    e_r = p / 'repository'
    e_d = p / 'dao'
    e_db = p / 'db'
    e_vm = p / 'viewmodel'
    def der():
        for s in ['nut','zap']:
            dao_entity_repository(s,'cat')

        for _ in ybag:
            print(_)
        for _ in bbag:
            print(_)
        for _ in rbag:
            print(_)
        for _ in gbag:
            print(_)
        for _ in vbag:
            print(_)


    def DB():
        db('Bae','cat')

    def VM():
        vm('Fuz','cat')

    # der()
    # DB()
    # VM()