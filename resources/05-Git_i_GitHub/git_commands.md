# What is a version control system?
A version control system (VCS) in programming is a tool that helps developers manage changes to their source code over time. It allows multiple developers to collaborate on a project, keep track of changes, and revert to previous versions if necessary. Key features of a version control system include:
Repositories: Storage locations for your code and its history.
Commits: Snapshots of changes made to the codebase.
Branches: Independent lines of development that can be merged together.
Merges: Combining changes from different branches.
Pull/Push: Synchronizing changes between local and remote repositories.

# Examples of real-world projects where version control systems played a critical role in success
* Linux Kernel: The development of the Linux kernel involves thousands of contributors worldwide. Version control systems, particularly Git, are essential for managing this massive collaborative effort.
* Apache Software Foundation: Projects under the Apache Software Foundation, such as Apache HTTP Server and Apache Hadoop, rely heavily on version control systems for collaborative development and release management.
* Microsoft Windows: The development of Microsoft Windows involves a large team of developers. Version control systems are used to manage the complex codebase and ensure that changes are tracked and coordinated effectively.

# Benefits of using version control systems
Improved collaboration: Version control systems facilitate teamwork by allowing multiple developers to work on the same codebase simultaneously.
History tracking: Changes made to the codebase are recorded, making it easy to track who made what changes and when.
Rollback capabilities: If a bug is introduced, developers can revert to a previous version of the codebase to fix the issue.
Branching and merging: Version control systems allow developers to work on different features or bug fixes independently, then merge them back into the main codebase when ready.

# CVS vs SVN vs git
CVS: Concurrent Version System, operuje na plikach (problemy ze zmianą nazw), identyfikatory: liczby
SVN: Apache Subversion, operuje na plikach (ale zmiana nazw możliwa, identyfikatory: liczby
Git: Git, operuje na tekście, identyfikatory: SHA-1

# Motivations behind git development:
* Performance: Git was designed to handle large projects efficiently, such as the Linux kernel, which involves thousands of contributors and a massive codebase.
* Distributed Workflow: The Linux kernel development process is highly distributed, with contributors from around the world. Git's distributed nature allows developers to work independently and synchronize changes later.
* Branching and Merging: Git provides more efficient and powerful branching and merging capabilities compared to existing systems like CVS and SVN.
* Data Integrity: Git uses a hashing mechanism (SHA-1) to ensure the integrity of the data, which was a significant improvement over existing systems.
* Speed: Git was designed to be fast, particularly for operations like committing, branching, and merging.
* Local Operations: Git allows most operations to be performed locally, reducing the need to connect to a central server and enabling offline work.

# Commands

### init
When you run `git init` in a folder, Git creates a new repository in that folder.
On top of that, it creates a .git subfolder which contains all the metadata and objects that Git needs to manage the repository.
Initial Files: 
* objects: Stores all the data for your repository.
* refs: Contains pointers to commits in your repository.
* HEAD: A file that points to the current branch you're working on.
* config: A file that contains configuration settings for your repository.

### clone
When you run git clone, you create a local copy of a remote repository. This is useful for working on a project hosted on a remote server like GitHub or GitLab.
You need to specify the URL of the remote repository you want to copy. For example `git clone https://github.com/user/repository.git`
By default, git clone creates a new directory with the same name as the repository. You can specify a different directory name by adding it as an argument:`git clone https://github.com/user/repository.git new_directory_name`
The command downloads all the files and metadata from the remote repository to your local machine. This includes all the branches, tags, and commit history.
After cloning, Git sets up remote tracking branches, allowing you to synchronize your local repository with the remote repository using commands like git fetch and git pull.

### config
Git configuration allows you to customize various aspects of your Git environment. You can set global configurations that apply to all repositories or local configurations that apply only to a specific repository.
To view your current Git configuration, use the command `git config --list`.
To set a global configuration, use the command `git config --global <key> <value>`. For example `git config --global user.email "your.email@example.com"`
To set a local configuration, use the command `git config <key> <value>`. For example `git config user.name "Your Name"`
List config fields: `git config --list`
Configuration Files: 
* System level: /etc/gitconfig
* Global level: ~/.gitconfig or ~/.config/git/config
* Local level: .git/config in the repository folder.

### checkout
The git checkout command is used for several purposes in Git, including switching branches, restoring files, and checking out specific commits
* `git checkout <branch_name>` switches to the specified branch.
* `git checkout <commit_hash>` checks out a specific commit.
* `git checkout -b <branch_name>` creates a new branch and switches to it.
* `git checkout -- <file_name>` restores a file to its state in the last commit.

### branch
The git branch command is used to list, create, or delete branches in a Git repository.
* `git branch ` lists all branches.
* `git branch <branch_name>` creates a new branch.
* `git branch -d <branch_name>` deletes a branch.
* `git branch -m <old_branch_name> <new_branch_name>` renames a branch.

### add
The git add command adds changes to the staging area, which is a list of changes that will be included in the next commit.
* `git add <file_name>` adds a specific file to the staging area.
* `git add .` adds all changes in the current directory to the staging area.
* `git add -A` adds all changes, including deletions, to the staging area.

Working Directory: This is the directory where you make changes to your files. It's the place where you edit, create, and delete files. The working directory contains the current state of your project.
Staging Area: This is an intermediate area where changes are prepared before they are committed to the repository. When you use the git add command, your changes are moved from the working directory to the staging area. This allows you to selectively stage changes and review them before making a commit.

If you decide not to commit the staged changes, you can unstage them using `git reset file_name` or to unstage all changes `git reset`

### commit
The git commit command takes a snapshot of the current state of your files and stores it in the repository's history.
It only commits changes that have been staged, i.e. added with `git add`. Each commit requires a message that describes the changes made.
* `git commit -m "Your commit message"`
* `git commit -am "Your commit message"` commits all changes in the working directory. (`git add` still needed but only for new files)
* `git commit --amend` amends the last commit.

### push
The git push command uploads your local commits to the remote repository, making them available to others.
* `git push origin <branch_name>` pushes the specified branch to the remote repository.
* `git push` - after the relation between the local branch and the remote branch has been set up with `git push -u origin <branch_name>`, you can use `git push` to push the current branch to the remote repository.
* `git push -f` forces the push, overwriting any changes on the remote repository.
* `git push --force-with-lease` forces the push, but only if the remote branch has not been modified since the last push.
* `git push --set-upstream origin <branch_name>` sets up the tracking information for the current branch to push to the remote repository.
* `git push --delete origin <branch_name>` deletes the specified branch from the remote repository.
* `git push --tags` pushes all tags to the remote repository.
* `git push --all` pushes all branches to the remote repository.

### pull
The git pull command is used to fetch and download content from a remote repository and immediately update the local repository to match that content.
* `git pull remote_name branch_name` - to pull changes from a specific branch of a remote repository
* `git pull` - to pull changes from the default remote repository and default branch
* `git pull --rebase` - to pull changes from the default remote repository and default branch, but rebase the local branch onto the remote branch instead of merging

### Kiedy zdarzają się konflikty?
* Simultaneous Changes: When multiple developers work on the same file and make changes to the same lines of code, conflicts can occur when trying to merge or push these changes.
* Out-of-Sync Branches: If your local branch is not up-to-date with the remote branch and you make changes that conflict with changes made by someone else, conflicts can occur when you try to push your changes.
* Merging Branches: When merging branches that have changes to the same part of a file, conflicts can arise if the changes are not compatible.

### Jak rozwiązywać konflikty?
* Communication: Maintain open communication within the team about who is working on what. This can help prevent multiple people from making changes to the same part of the code simultaneously.
* Feature Branches: Use feature branches for developing new features or making significant changes. This isolates changes and makes it easier to manage and merge them.
* Frequent Pulls: Encourage team members to pull changes from the remote repository frequently. This helps to keep their local branches up-to-date and reduces the chance of conflicts.

### blame
The git blame command provides a line-by-line annotation of a file, showing the author, commit hash, and timestamp of the last modification for each line.
* `git blame file_name`

### log
The git log command shows the commit history of the repository, including the commit hash, author, date, and commit message.
* `git log` - shows the full commit history
* `git log --oneline` - shows the commit history in a single line per commit
* `git log --graph` - shows the commit history in a graphical format
* `git log -n` - shows the last n commits
* `git lg`

### cherry-pick
The git cherry-pick command allows you to apply the changes from a specific commit to your current branch.
* `git cherry-pick commit_hash` - applies the changes from the specified commit to the current branch
* `git cherry-pick -n commit_hash` - applies the changes from the specified commit to the current branch without committing
* `git cherry-pick --continue` - continues the cherry-pick operation after resolving conflicts
* `git cherry-pick --abort` - aborts the cherry-pick operation
* `git cherry-pick --edit` - allows you to edit the commit message before committing the changes

### merge






