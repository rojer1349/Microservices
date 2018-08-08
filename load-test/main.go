package main
import (
        "fmt"
        "log"
        "net/http"
        "os"
        "time"
)
func main() {
        port := "8080"
        server := http.NewServeMux()
        server.HandleFunc("/", app)
        log.Printf("Server listening on the port %s", port)
        err := http.ListenAndServe(":"+port, server)
        log.Fatal(err)
}
func app(w http.ResponseWriter, r *http.Request) {
        log.Printf("Serving request: %s", r.URL.Path)
        host, _ := os.Hostname()
        fmt.Fprintf(w, "Hello, Edinburgh!\n")
        fmt.Fprintf(w, "Pod Name: %s\n", host)
        done := make(chan int) 
  for i := 0; i < 2; i++ { 
    go func() { 
      for { 
        select { 
          case <-done: return 
          default: 
        } 
      } 
    }()
  }
  time.Sleep(time.Second)
}