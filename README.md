# FundApps Demo - Petr Hoffmann
### Running my code
To compile use the following command in the project's root directory:
```bash
./gradlew run # UNIX
gradlew.bat run # Windows
```

For running tests:
```bash
./gradlew check # UNIX
gradlew.bat check # Windows
```

### My reflection
I enjoyed completing this task a lot. I'd like to say my code is simple and
self-documenting. There are few comments throughout the code, because I didn't
want to add comments just for the sake of having them. Normally I would take
time to write JavaDoc comments for at least the public methods, but setting up
the tools that would validate them and benefit from them was outside of the 2h
scope.

I set a timer for 1h 45min before starting the task, but I was finished with the
required functionality a few minutes before it went off. I'm happy with my
solution and I would not do any drastic changes even if I had more time.

The timer started with the following commit: 67dfd7af343912f599f22f0da1701ee742b77131 (10:50am).

I finished coding with the following commit: 234d3572d5a971072bf71083d0f421a5799a68e4 (12:19pm).

Now I'm finishing the README after having a lunch :)

If this was a long-term project, I would set up a CI pipeline, that would
enforce the following:
* Program compiles
* Tests pass
* Test coverage meets defined criteria
* Code style is compliant
* Static analysis passes (eg. SonarQube)
