package dynamic.matixmultiplay;

public class Result {
  // 最优解的值
  Object expect;
  // 最优解的路径
  String path;

  public Result(Object expect, String path) {
    this.expect = expect;
    this.path = path;
  }


  public Object getExpect() {
    return expect;
  }

  public String getPath() {
    return path;
  }

  @Override
  public String toString() {
    return "Result{" +
        "expect=" + expect +
        ", path='" + path + '\'' +
        '}';
  }
}
