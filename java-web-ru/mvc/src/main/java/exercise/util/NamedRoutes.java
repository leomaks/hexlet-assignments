package exercise.util;

import exercise.controller.PostsController;

public class NamedRoutes {

    public static String editPath(Long id) {
        return "/posts/"+String.valueOf(id)+ "/edit";
    }

    public static String editPath(String id) {
        return "/posts/"+id+ "/edit";
    }

    public static String updatePath(Long id) {
        return "/posts/" + String.valueOf(id);
    }
    public static String updatePath(String id) {
        return "/posts/" + id;
    }
    // END
    public static String rootPath() {
        return "/";
    }

    public static String postsPath() {
        return "/posts";
    }

    public static String buildPostPath() {
        return "/posts/build";
    }

    public static String postPath(Long id) {
        return postPath(String.valueOf(id));
    }

    public static String postPath(String id) {
        return "/posts/" + id;
    }


}
