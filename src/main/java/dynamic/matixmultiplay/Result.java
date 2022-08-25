package dynamic.matixmultiplay;

public class Result {
  // 最优解的值
  Object expect;
  // 最优解的路径
  Object path;

  public Result(Object expect, Object path) {
    this.expect = expect;
    this.path = path;
  }


  public Object getExpect() {
    return expect;
  }

  public Object getPath() {
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
