# node-exporter stack module

- Module id: `node-exporter`
- Module repo: `node-exporter-stack-module`
- Source repo: none declared
- Lifecycle: `active`

## Owned overlays
- `stack.compose/node-exporter.yml`

## Dependencies
- `prometheus`
- `stack-foundation`

## Validation

```sh
./tests/validate.sh
```

## Lifecycle

`active` modules are expected to keep `stack.module.json`, owned overlays, and `tests/validate.sh` in sync.
