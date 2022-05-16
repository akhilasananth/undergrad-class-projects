package springexample.mainDir;

/**
 * Created by akhilaananth on 1/26/2017.
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, String> {


}