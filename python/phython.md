## phython

from collections import defaultdict

d=defaultdict(list)

s=['Hello','World','Hello','World']

for index,key in enumerate(s):

​    d[key].append(index)

print(d)

print(d.items())

print(dict(d))