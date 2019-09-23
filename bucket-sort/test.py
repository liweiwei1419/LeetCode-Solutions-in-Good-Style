import subprocess
out = subprocess.call("ls -l", shell=True)

print(out)