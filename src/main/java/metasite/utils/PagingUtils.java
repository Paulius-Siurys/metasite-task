package metasite.utils;

/**
 * Created by paulius on 10/11/2015.
 */
public class PagingUtils {
	public static int getFirstResult(int page, int pageSize) {
		--page;
		return pageSize * page;
	};
}
