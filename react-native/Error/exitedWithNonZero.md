##Error:Packager exited with non-zero exit code

***resolution***
	- terminal
	cd /proc/sys/fs/inotify
    echo 99999 | sudo tee -a max_queued_events
	echo 99999 | sudo tee -a max_user_instances
	echo 99999 | sudo tee -a max_user_watches
	watchman shutdown-server
