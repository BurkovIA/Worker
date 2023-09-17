public class Worker {
    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String task);
    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String task);
    }

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 33) {
                errorCallback.onError("Задача " + i + " ошибка");
            } else {
                callback.onDone("Задача " + i + " выполнена");
            }
        }
    }
}