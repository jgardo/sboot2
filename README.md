# sboot2
Sample reactive application with reactive httpclient.
This service get a number as a parameter, decrements it and send self request to recrusively until it reach zero. The output is not important.

Important thing about this project that it is reactive.
Normally nonreactive sending http request is blocking thread (and requires one thread to one processed request), so invoking endpoint with path param equal to 3000 would finally require 3000 (working/sleeping) threads.

Reactive approach does not require thread per currently processed request, so it in theory it requires only one processing thread.

In practice we can see that amount of threads is not increasing, so it works as we expect.

