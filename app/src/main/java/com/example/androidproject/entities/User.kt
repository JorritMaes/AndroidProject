import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.androidproject.entities.Account
import com.example.androidproject.entities.Event
//Room : https://www.youtube.com/watch?v=lwAvI3WDXBY
@Entity(tableName = "Users")
data class User(@PrimaryKey(autoGenerate = false) var username: String) {
    var accounts: ArrayList<Account> = ArrayList()
    var friends: ArrayList<User> = ArrayList()
    var acceptedEvents: ArrayList<Event> = ArrayList()
    var pendingEvents: ArrayList<Event> = ArrayList()
}