# Git i GitHub

### Opis
Ten wykład to wprowadzenie do systemu kontroli wersji Git oraz jego praktycznych zastosowań. Zaczniemy od omówienia, czym są systemy kontroli wersji, ich ewolucji od CVS i SVN do Gita oraz motywacji stojących za stworzeniem Gita przez Linusa Torvaldsa. Przyjrzymy się również statystykom dotyczącym użycia różnych systemów kontroli wersji wśród programistów.

Następnie omówimy podstawowe polecenia Gita, takie jak `init`, `clone`, `checkout`, `branch`, `commit` i `push`, które są niezbędne do codziennego użytkowania. Poruszymy również kwestię rozwiązywania konfliktów w Git: omówimy sytuacje, w których występują konflikty, oraz jak sobie z nimi radzić za pomocą poleceń takich jak `blame`, `cherry-pick`, `merge`, `rebase`, `reflog` i `reset`.

Następnie omówimy podstawowe modele pracy z git'em, oraz platformę GitHub. Pokażę studentom, jak założyć repozytorium, wybrać odpowiednią licencję i omówię funkcje GitHuba, takie jak Issues, Pull Requests i GitHub Actions. Dodatkowo omówimy krótko platformę GitLab oraz wtyczkę GitHub w IntelliJ IDEA.

### Plan wykładu

* Wprowadzenie do systemu wersjonowania git
  * Co to jest system wersjonowania?
  * Jakie systemy wersjonowania istniały przed gitem? (CVS, SVN)
  * Kto i kiedy stworzył git (Linus Torvalds)
  * Jaka była motywacja, tzn. problemy z poprzednimi systemami wersjonowania, i jak git je rozwiązuje?
  * Statystyki, jaki procent programistów uzywa jakiego systemu wersjonowania

* Podstawowe komendy git
  * init
  * clone (ssh, http)
  * config
  * checkout (-b, -i, squash)
  * branch
  * commit (-a, -m)
  * push (-f)

* Rozwiązywanie konfliktów
  * Sytuacje w jakich zdarzają się konflikty 
  * blame
  * cherry-pick
  * merge
  * rebase
  * reflog
  * reset 

* Co to jest Git Flow? (https://www.gitkraken.com/learn/git/git-flow)

* Wprowadzenie do platformy GitHub
  * Zakładanie konta i pierwszego repozytorium. Kontakt z lokalnym systemem git.
  * Plik README i omówienie licencji open source
  * .gitignore
  * Przeglądanie kodu (historia, github.dev, GitHub Desktop)
  * GitHub Issues
  * Pull Requests (jak powstaje code review?)
  * Podstawy GitHub Actions

* Krótka notka o GitLab

* Git Plugin w IntelliJ IDEA
  * Code history
  * Code review 