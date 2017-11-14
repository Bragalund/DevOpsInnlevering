#!/bin/sh
chmod +x ./git-create

repo_name=$1
username='bragalund'
test -z $repo_name && echo "Repo name required." 1>&2 && exit 1

curl -u $username https://api.github.com/user/repos -d "{\"name\":\"$repo_name\"}"

git init
git add .
git commit -m "First commit"
git remote add origin "git@github.com:/$username/$repo_name.git"
git push origin master
